package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Deferred
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.cancel.delaySuspendCancellableCoroutine
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
//没有获取的话，有异常也不会抛出来
class DeferredCoroutine<T>(context: CoroutineContext) : AbstractCoroutine<T>(context), Deferred<T> {
    override suspend fun await(): T {
        return when(val currentState = state.get()){
            is CoroutineState.Cancelling,
            is CoroutineState.InComplete -> awaitSuspend()
            is CoroutineState.Complete<*> -> {
                coroutineContext[Job]?.isActive?.takeIf { !it }?.let {
                    throw CancellationException("Coroutine is cancelled.")
                }
//                直接强转
                (currentState.value as T?) ?: throw currentState.exception!!
            }
        }
    }
//跟joinSuspend很像，不同的是这个是有返回结果的
    private suspend fun awaitSuspend() = delaySuspendCancellableCoroutine<T> {
        continuation ->
        val disposable = doOnCompleted { result ->
//            这里的continuation会回调到StandardCoroutine的resumeWith，把结果放在state里，并改变state的状态
            continuation.resumeWith(result)
        }
        continuation.invokeOnCancelListener { disposable.dispose() }
    }
}