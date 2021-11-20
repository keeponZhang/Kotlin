package com.example.retrofittest

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

/**
 * Created by benny on 5/29/17.
 */
//使用伴生对象的特点,构造函数传一个对象
class TestContext : AbstractCoroutineContextElement(ContinuationInterceptor),
        ContinuationInterceptor {
    val test = "keepon"

    public final override fun <T> interceptContinuation(
            continuation: Continuation<T>
    ): Continuation<T> {
        log("TestContext interceptContinuation")
        return TestContinuation(continuation.context, continuation)
    }
}