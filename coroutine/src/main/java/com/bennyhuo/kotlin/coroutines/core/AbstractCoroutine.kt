package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.OnCancel
import com.bennyhuo.kotlin.coroutines.OnComplete
import com.bennyhuo.kotlin.coroutines.cancel.suspendCancellableCoroutine
import com.bennyhuo.kotlin.coroutines.context.CoroutineName
import com.bennyhuo.kotlin.coroutines.scope.CoroutineScope
//import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.resume

abstract class AbstractCoroutine<T>(context: CoroutineContext) :
        Job, Continuation<T>, CoroutineScope {

    protected val state = AtomicReference<CoroutineState>()

    //    只要拿到context，就能拿到job实例
    override val context: CoroutineContext = context + this

    override val scopeContext: CoroutineContext
        get() = context

    //是传进来的context
    protected var parentJob = context[Job]

    private var parentCancelDisposable: Disposable? = null

    init {
        state.set(CoroutineState.InComplete())
//        爹取消了，自己也要取消，不管是不是协同还是主从
        parentCancelDisposable = parentJob?.invokeOnCancel {
            log("AbstractCoroutine parentJob init cancel")
            cancel()
        }
    }

    override val isActive: Boolean
        get() = state.get() is CoroutineState.InComplete

    override val isCompleted: Boolean
        get() = state.get() is CoroutineState.Complete<*>

    override fun invokeOnCompletion(onComplete: OnComplete): Disposable {
        return doOnCompleted {
            onComplete()
        }
    }

    override fun remove(disposable: Disposable) {
        state.updateAndGet { prev ->
            when (prev) {
                is CoroutineState.InComplete -> {
                    CoroutineState.InComplete().from(prev).without(disposable)
                }
//                完成的话啥状态也没有了
                is CoroutineState.Complete<*> -> prev
                is CoroutineState.Cancelling -> {
//                    这里会更新状态
                    CoroutineState.Cancelling().from(prev).without(disposable)
                }
            }
        }
    }

    override suspend fun join() {
        when (state.get()) {
            is CoroutineState.Cancelling,
            is CoroutineState.InComplete -> return joinSuspend()
//            如果调用我join的这个协程已经取消
            is CoroutineState.Complete<*> -> {
//                获取到当前协程的coroutineContext（不是this）
                log("***********join CoroutineState.Complete*************************")
                val currentCallingJobState = coroutineContext[Job]?.isActive ?: return
//一旦为false，一定是被取消了
                log("***********join currentCallingJobState=$currentCallingJobState ")
                if (!currentCallingJobState) {
                    throw CancellationException("Coroutine is cancelled.")
                }
                return
            }
        }
    }

    //    跟invokeOnCompletion有点像
    private suspend fun joinSuspend() = suspendCancellableCoroutine<Unit> { continuation ->
        val disposable = doOnCompleted { result ->
//            问题是这个什么时候会回调，那就要看block在doOnCompleted什么时候会回调，还要注意这里返回了一个disposable
//            这里只关心是不是执行完了，所以传Unit
            continuation.resume(Unit)
        }
        log("AbstractCoroutine 调用 joinSuspend ")
//    disposable.dispose() 就是一个cancel
        continuation.invokeOnCancel {
            log("AbstractCoroutine 取消执行invokeOnCancel")
            disposable.dispose()
        }
    }

    //如果已经完成，就回调block，不然就放在state里面，完成后会调用
    protected fun doOnCompleted(block: (Result<T>) -> Unit): Disposable {
//        注意，这里disposable会保存到CoroutineState里面
        val disposable = CompletionHandlerDisposable(this, block)
        val newState = state.updateAndGet { prev ->
            when (prev) {
//                这里要获取最新的状态
                is CoroutineState.InComplete -> {
                    CoroutineState.InComplete().from(prev).with(disposable)
                }
                is CoroutineState.Cancelling -> {
                    CoroutineState.Cancelling().from(prev).with(disposable)
                }
                is CoroutineState.Complete<*> -> {
                    prev
                }
            }
        }
//如果成功就直接回调了，没有的话就要看CompletionHandlerDisposable什么时候调用dispose了
//  没有成功的话会通过resumeWith->  notifyCompletion    -》找出CompletionHandlerDisposable，调用onComplete
        (newState as? CoroutineState.Complete<T>)?.let {
            block(
                    when {
                        it.value != null -> Result.success(it.value)
                        it.exception != null -> Result.failure(it.exception)
                        else -> throw IllegalStateException("Won't happen!")
                    }
            )
        }

        return disposable
    }

    override fun resumeWith(result: Result<T>) {
        val newState = state.updateAndGet { prevState ->
            when (prevState) {
                is CoroutineState.Cancelling,
                is CoroutineState.InComplete -> {
//                   创建了一个新的状态并且更新了state
                    CoroutineState.Complete(result.getOrNull(), result.exceptionOrNull())
                            .from(prevState)
                }
                is CoroutineState.Complete<*> -> {
                    throw IllegalStateException("Already completed!")
                }
            }
        }

//        如果协程抛异常的话，要处理异常
        (newState as CoroutineState.Complete<T>).exception?.let(::tryHandleException)

        newState.notifyCompletion(result)
        newState.clear()
//        其实会回调到父协程的remove(disposable: Disposable)，移除，因为此时不需要父协程的回调了
        parentCancelDisposable?.dispose()
    }

    private fun tryHandleException(e: Throwable): Boolean {
        return when (e) {
            is CancellationException -> false
            else -> {
//协同关系可以抛给父协程，主从关系就不能抛给父协程，handleJobException(e)相对于前面返回空了
                (parentJob as? AbstractCoroutine<*>)?.handleChildException(e)?.takeIf { it }
                        ?: handleJobException(e)
            }
        }
    }

    protected open fun handleJobException(e: Throwable): Boolean {
        return false
    }

    //    子类抛异常了，会先抛上去让父协程处理
    protected open fun handleChildException(e: Throwable): Boolean {
//        先把自己取消
        cancel()
//    然后问问直接能不能处理
        return tryHandleException(e)
    }

    override fun invokeOnCancel(onCancel: OnCancel): Disposable {
        val disposable = CancellationHandlerDisposable(this, onCancel)
//        dispose会被保存到CoroutineState，后面对于dispose的时候会用到
        val newState = state.updateAndGet { prev ->
            when (prev) {
                is CoroutineState.InComplete -> {
                    CoroutineState.InComplete().from(prev).with(disposable)
                }
                is CoroutineState.Cancelling,
                is CoroutineState.Complete<*> -> {
                    prev
                }
            }
        }
        //如果已经是cancel，就执行onCancel；否则的话是有人调用了CoroutineState.notifyCancellation从而触发到onCancel被调用
        (newState as? CoroutineState.Cancelling)?.let {
            log("AbstractCoroutine 调用invokeOnCancel，此时已经是取消状态了，执行取消")
            onCancel()
        }
        return disposable
    }

    override fun cancel() {
        val newState = state.updateAndGet { prev ->
            when (prev) {
                is CoroutineState.InComplete -> {
                    CoroutineState.Cancelling().from(prev)
                }
                is CoroutineState.Cancelling,
                is CoroutineState.Complete<*> -> {
                    prev
                }
            }
        }

        if (newState is CoroutineState.Cancelling) {
//            这里很重要，会触发到onCancel代码块的回调
            log(" AbstractCoroutine 调用cancel方法 newState.notifyCancellation()" +
                    "（AbstractCoroutine.cancel）")
            newState.notifyCancellation()
        }

        parentCancelDisposable?.dispose()
    }

    override fun toString(): String {
        return "${context[CoroutineName]?.name}"
    }
}