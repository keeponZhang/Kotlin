package com.bennyhuo.kotlin.coroutines.cancel

import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.OnCancel
import com.bennyhuo.kotlin.coroutines.utils.log
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.intercepted
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

//需要有状态
open class CancellationContinuation<T>(
        private val continuation: Continuation<T>, val isJoin: Boolean =
                true
) :
        Continuation<T> by continuation {

    init {
        val name = if (isJoin) "join" else "delay"
//        launch里面调用的会是DispatchedContinuation
        log("$name----init创建实例----传进来的continuation=$continuation ")
    }

    private val state = AtomicReference<CancelState>(CancelState.InComplete)

    //这里弄简单点
    private val cancelHandlers = CopyOnWriteArrayList<OnCancel>()

    val isCompleted: Boolean
        get() = state.get() is CancelState.Complete<*>

    val isActive: Boolean
        get() = state.get() == CancelState.InComplete

    override fun resumeWith(result: Result<T>) {
        state.updateAndGet { prev ->
            when (prev) {
                CancelState.InComplete -> {
                    log("准备调用resume--------continuation=$continuation prev=${prev} result=$result")
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

    //    这里会监听父job，父job取消了，会调用doCancel，这里跟AbstractCoroutine的invokeOnCancelListener不一样
    fun invokeOnCancelListener(onCancel: OnCancel) {
        cancelHandlers += onCancel
        log("增加监听，cancelHandlers.size=${cancelHandlers.size}")
    }

    val name = if (isJoin) "join" else "delay"

    //这里是block代码执行完，判断有没取消，如果取消了，block的延迟任务取消调
    fun getResult(): Any? {
        log("获取结果1,state=${state.get()}")
        installCancelHandler()
        val currentState = state.get()
        log("获取结果2（这个有可能改变）currentState=${currentState}")
        val any = when (currentState) {
            is CancelState.InComplete -> COROUTINE_SUSPENDED
            is CancelState.Complete<*> -> {
                (currentState as CancelState.Complete<T>).let {
                    it.exception?.let { throw it } ?: it.value
                }
                log("CancelState.Complete")
            }
            is CancelState.Cancelled -> {
//                这里直接抛异常了，会resume线程
                log("CancelState.Cancelled")
                throw CancellationException("Continuation is cancelled.")
            }
        }
        log("返回值result=$any")
        return any
    }

    private fun installCancelHandler() {

        if (!isActive) return
        val job = continuation.context[Job]
        if (job == null) {
            log("获取job,返回了null--------------")
        }
        val parent = job ?: return
        log("来获取job=$parent")
//        这里就是设置监听，父job取消，子job也会被取消，最原始的那个Job
        parent.invokeOnCancelListener {
            log("回调parent.cancel,表示parent已经是取消状态了")
            doCancel()
        }
    }

    //改变状态
    private fun doCancel() {
        state.updateAndGet { prev ->
            log("doCancel里prev=$prev ")
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
//        回调到监听，之后会回调到AbstractCoroutine的remvoe
        cancelHandlers.forEach(OnCancel::invoke)
        cancelHandlers.clear()
    }
}

//suspendCoroutineUninterceptedOrReturn会对传进来的Continuation做一层拦截cont -> block(cont.intercepted())
//CancellationContinuation相当于SafeContinuation的作用，c传的是外层的Continuation
suspend inline fun <T> delaySuspendCancellableCoroutine(
        crossinline block: (CancellationContinuation<T>) -> Unit
): T = suspendCoroutineUninterceptedOrReturn { c: Continuation<T> ->
    val intercepted = c.intercepted()
    log("delaySuspendCancellableCoroutine的suspendCoroutineUninterceptedOrReturn里包装的block,参数1:c=$c" +
            ",参数2:intercepted=$intercepted")
    val cancellationContinuation = CancellationContinuation(intercepted, false)
    block(cancellationContinuation)
    log("delaySuspendCancellableCoroutine里面调用getResult")
    cancellationContinuation.getResult()
}

suspend inline fun <T> joinSuspendCancellableCoroutine(
        crossinline block: (CancellationContinuation<T>) -> Unit
): T = suspendCoroutineUninterceptedOrReturn { c: Continuation<T> ->
    val intercepted = c.intercepted()
    log("joinSuspendCancellableCoroutine的suspendCoroutineUninterceptedOrReturn里包装的block,参数1:c=$c," +
            "参数2:intercepted=$intercepted")
    val cancellationContinuation = CancellationContinuation(intercepted)
    block(cancellationContinuation)
    log("joinSuspendCancellableCoroutine里面调用getResult")
    cancellationContinuation.getResult()
}