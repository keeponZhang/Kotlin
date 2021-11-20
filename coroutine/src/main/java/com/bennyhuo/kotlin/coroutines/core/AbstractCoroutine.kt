package com.bennyhuo.kotlin.coroutines.core

//import com.sun.org.apache.xpath.internal.operations.Bool
import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.OnCancel
import com.bennyhuo.kotlin.coroutines.OnComplete
import com.bennyhuo.kotlin.coroutines.cancel.joinSuspendCancellableCoroutine
import com.bennyhuo.kotlin.coroutines.scope.CoroutineScope
import com.bennyhuo.kotlin.coroutines.utils.log
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.resume

//需要泛型参数，因为有返回值，Continuation是一开始创建或者启动协程用的Continuation，最后恢复需要用到
abstract class AbstractCoroutine<T>(context: CoroutineContext) :
        Job, Continuation<T>, CoroutineScope {

    protected val state = AtomicReference<CoroutineState>()

    //只要拿到context，就能拿到job实例（这里的this就是把job加上去）
    override val context: CoroutineContext = context + this

    //    这里的scopeContext等于context
    override val scopeContext: CoroutineContext
        get() = context

    //是传进来的context，传进来的context[Job]就是父协程的job
    protected var parentJob = context[Job]

    private var parentCancelDisposable: Disposable? = null

    init {
        state.set(CoroutineState.InComplete())
//        爹取消了，自己也要取消，不管是不是协同还是主从
        parentCancelDisposable = parentJob?.invokeOnCancelListener {
            log("parentJob init cancel")
            cancel()
        }
    }

    override val isActive: Boolean
        get() = state.get() is CoroutineState.InComplete

    override val isCompleted: Boolean
        get() = state.get() is CoroutineState.Complete<*>

    override fun invokeOnCompletionListener(onComplete: OnComplete): Disposable {
        return doOnCompleted {
            onComplete()
        }
    }

    //    就是移除完成和取消的监听(需要作状态转移)
    override fun remove(disposable: Disposable) {
        state.updateAndGet { prev ->
            log("prev=$prev")
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

    //挂起
    override suspend fun join() {
        val state = state.get()
        log("state=$state")
        when (state) {
            is CoroutineState.Cancelling,
            is CoroutineState.InComplete -> return joinSuspend()
//            如果调用我join的这个协程已经取消
            is CoroutineState.Complete<*> -> {
//                获取到当前协程的coroutineContext（不是this）
                val currentCallingJobState = coroutineContext[Job]?.isActive ?: return
                log("currentCallingJobState=$currentCallingJobState")
//一旦为false，一定是被取消了
                if (!currentCallingJobState) {
                    throw CancellationException("Coroutine is cancelled.")
                }
                return
            }
        }
    }

    //    跟invokeOnCompletion有点像
    private suspend fun joinSuspend() = joinSuspendCancellableCoroutine<Unit> { continuation ->
        log("执行到真正的block,continuation=$continuation,  准备调用doOnCompleted")
        val disposable = doOnCompleted { result ->
//            问题是这个什么时候会回调，那就要看block在doOnCompleted什么时候会回调，还要注意这里返回了一个disposable
//            这里只关心是不是执行完了，所以传Unit.这里的是CancellationContinuation
            log("回调doOnCompleted,continuation=$continuation")
            continuation.resume(Unit)
        }
//   增加continuation的移除监听,这里是包装后的cancellationContinuation，监听是监听原始的continuation
        continuation.invokeOnCancelListener {
            log("取消执行invokeOnCancel")
//            disposable.dispose() 就是移除监听
            disposable.dispose()
        }
        log("执行完,接着会调用getResult")
    }

    //如果已经完成，就回调block，不然就放在state里面，完成后会调用，可能join的时候已经完成或者join的时候还没完成（此时需要设置回调）
//    对返回的Disposable会处理（其实就是从state里移除，会回调到该类的remove）
    protected fun doOnCompleted(block: (Result<T>) -> Unit): Disposable {
//        注意，这里disposable会保存到CoroutineState里面
        val disposable = CompletionHandlerDisposable(this, block)
//       这里面并没有改变状态，只是可能设置回调
        val newState = state.updateAndGet { prev ->
            when (prev) {
                is CoroutineState.InComplete -> {
//                   传入 disposable其实就是设置回调
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
        log("newState=$newState")
//如果成功就直接回调了，没有的话就要看CompletionHandlerDisposable什么时候调用dispose了
//  没有成功的话会通过resumeWith->  notifyCompletion    -》找出CompletionHandlerDisposable，调用onComplete
        (newState as? CoroutineState.Complete<T>)?.let {
//            完成后回调给block传入参数
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

    //失败还是异常都会回调这里
    override fun resumeWith(result: Result<T>) {
        log(",!!!!!!!!!!!这里是complteContinutaion，完成或者失败的时候调用," +
                "result=${result.getOrNull()},(重要*****)continution=$this")
        val newState = state.updateAndGet { prevState ->
            when (prevState) {
                is CoroutineState.Cancelling,
                is CoroutineState.InComplete -> {
//                    为什么有可能执行多次？
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
        log("准备调用notifyCompletion来通知完成")
//        如果调用join,这里可能会去唤醒，join里面有个onComplete的block
        newState.notifyCompletion(result)
        log("准备调用newState.clear()清理newState")
        newState.clear()
//        其实会回调到父协程的remove(disposable: Disposable)，移除，因为此时不需要父协程的回调了
        //        dispose就是移除监听的，取消了也移除父协程取消的监听
        parentCancelDisposable?.dispose()
    }

    private fun tryHandleException(e: Throwable): Boolean {
        return when (e) {
            is CancellationException -> false
            else -> {
// parentJob as? AbstractCoroutine<*>，这里能直接转的原因是 override val context: CoroutineContext = context
// + this，这里AbstractCoroutine是个job
//协同关系可以抛给父协程，主从关系就不能抛给父协程，handleJobException(e)相对于前面返回空了
                (parentJob as? AbstractCoroutine<*>)?.handleChildException(e)?.takeIf { it }
                        ?: handleJobException(e)
            }
        }
    }

    //    这个如果没有父Job，会调用的
    protected open fun handleJobException(e: Throwable): Boolean {
        return false
    }

    //    子类抛异常了，会先抛上去让父协程处理，一般由子协程处理
    protected open fun handleChildException(e: Throwable): Boolean {
//        先把自己取消
        cancel()
//    然后问问直接能不能处理
        return tryHandleException(e)
    }

    override fun invokeOnCancelListener(onCancel: OnCancel): Disposable {
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
            log("newState is CoroutineState.Cancelling,此时已经是取消状态了，执行取消")
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
            log(
                    "此时已经是取消状态，newState.notifyCancellation()"

            )
            newState.notifyCancellation()
        }

//        dispose就是移除监听的，取消了也移除父协程取消的监听
        parentCancelDisposable?.dispose()
    }

//    override fun toString(): String {
//        return "${context[CoroutineName]?.name}"
//    }
}