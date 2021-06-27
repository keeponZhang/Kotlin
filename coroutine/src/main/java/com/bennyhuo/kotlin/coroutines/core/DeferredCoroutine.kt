package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutines.CancellationException
import com.bennyhuo.kotlin.coroutines.Deferred
import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.cancel.suspendCancellableCoroutine
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
    private suspend fun awaitSuspend() = suspendCancellableCoroutine<T> {
        continuation ->
        val disposable = doOnCompleted { result ->
            continuation.resumeWith(result)
        }
        continuation.invokeOnCancel { disposable.dispose() }
    }
}