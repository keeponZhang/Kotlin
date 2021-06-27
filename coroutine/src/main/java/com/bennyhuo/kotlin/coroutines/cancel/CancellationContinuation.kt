package com.bennyhuo.kotlin.coroutines.cancel

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.OnCancel
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.intercepted
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

//需要有状态
class CancellationContinuation<T>(private val continuation: Continuation<T>) :
        Continuation<T> by continuation {

    init {
        log("--------传进来的continuation $continuation")
    }
    private val state = AtomicReference<CancelState>(CancelState.InComplete)

    private val cancelHandlers = CopyOnWriteArrayList<OnCancel>()

    val isCompleted: Boolean
        get() = state.get() is CancelState.Complete<*>

    val isActive: Boolean
        get() = state.get() == CancelState.InComplete

    override fun resumeWith(result: Result<T>) {
        log("CancellationContinuation 调用resumeWith-----")
        state.updateAndGet { prev ->
            when (prev) {
                CancelState.InComplete -> {
                    continuation.resumeWith(result)
                    CancelState.Complete(result.getOrNull(), result.exceptionOrNull())
                }
                is CancelState.Complete<*> -> throw IllegalStateException("Already completed.")
                CancelState.Cancelled -> {
                    CancellationException("Cancelled.").let {
                        continuation.resumeWith(Result.failure(it))
                        CancelState.Complete(null, it)
                    }
                }
            }
        }
    }

    fun cancel() {
        if (!isActive) return
//        我所在的父协程要拿到
        val parent = continuation.context[Job] ?: return
        parent.cancel()
    }

    fun invokeOnCancel(onCancel: OnCancel) {
        cancelHandlers += onCancel
        log("CancellationContinuation 调用invokeOnCancel（增加监听)，cancelHandlers.size ${cancelHandlers
                .size}")
    }

    //这里是block代码执行完，判断有没取消，如果取消了，block的延迟任务取消调
    fun getResult(): Any? {
        log("CancellationContinuation 调用getResult() ${state.get()}")
        installCancelHandler()
        return when (val currentState = state.get()) {
            CancelState.InComplete -> COROUTINE_SUSPENDED
            is CancelState.Complete<*> -> {
                (currentState as CancelState.Complete<T>).let {
                    it.exception?.let { throw it } ?: it.value
                }
            }
            CancelState.Cancelled -> throw CancellationException("Continuation is cancelled.")
        }
    }

    private fun installCancelHandler() {

        if (!isActive) return
        val job = continuation.context[Job]
        if (job == null) {
            log("CancellationContinuation 调用installCancelHandler 返回了--------------")
        }
        val parent = job ?: return
        log("CancellationContinuation 调用installCancelHandler $parent")
        parent.invokeOnCancel {
            log("CancellationContinuation 回调parent cancel")
            doCancel()
        }
    }

    private fun doCancel() {
        log("CancellationContinuation 调用doCancel ")
        state.updateAndGet { prev ->
            when (prev) {
                CancelState.InComplete -> {
                    CancelState.Cancelled
                }
                is CancelState.Complete<*>,
                CancelState.Cancelled -> {
                    prev
                }
            }
        }
        log("触发监听-》清除监听")
        cancelHandlers.forEach(OnCancel::invoke)
        cancelHandlers.clear()
    }
}

//CancellationContinuation相当于SafeContinuation的作用，c传的是外层的Continuation
suspend inline fun <T> suspendCancellableCoroutine(
        crossinline block: (CancellationContinuation<T>) -> Unit
): T = suspendCoroutineUninterceptedOrReturn { c: Continuation<T> ->
    val cancellationContinuation = CancellationContinuation(c.intercepted())
    block(cancellationContinuation)
    cancellationContinuation.getResult()
}