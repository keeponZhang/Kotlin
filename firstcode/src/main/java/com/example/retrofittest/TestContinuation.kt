package com.example.retrofittest

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

//context 是父类继承下来的
class TestContinuation<in T>(
        override val context: CoroutineContext = EmptyCoroutineContext,
        val continuation: Continuation<T>
) :
        Continuation<T> {
    override fun resumeWith(result: Result<T>) {
        log("TestContinuation result" + result)
        continuation.resumeWith(result)
    }
}