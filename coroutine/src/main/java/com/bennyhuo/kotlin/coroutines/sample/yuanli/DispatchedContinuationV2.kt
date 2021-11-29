package com.bennyhuo.kotlin.coroutines.sample.yuanli

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

/**
 * createBy	 keepon
 */
class DispatchedContinuationV2<T>(
        val continuation: Continuation<T>,
        override val context: CoroutineContext
) : Continuation<T> {
    override fun resumeWith(result: Result<T>) {

        continuation.resumeWith(result)
    }
}