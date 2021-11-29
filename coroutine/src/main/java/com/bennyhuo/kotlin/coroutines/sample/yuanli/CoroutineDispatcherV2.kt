package com.bennyhuo.kotlin.coroutines.sample.yuanli

import kotlin.coroutines.Continuation

public class CoroutineDispatcherV2(
        val name: String
) : AbstractCoroutineContextElementV2(ContinuationInterceptorV2), ContinuationInterceptorV2 {
    public companion object Key : CoroutineContextV2.KeyV2<ContinuationInterceptorV2>

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return DispatchedContinuationV2(continuation, continuation.context)
    }

    override fun toString(): String = "${javaClass.simpleName}:($name)"
}