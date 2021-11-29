package com.bennyhuo.kotlin.coroutine.ch03

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.suspendCoroutine

suspend fun suspendFunc01(a: Int) {
    return
}

//public suspend inline fun <T> suspendCoroutineOrReturn(crossinline block: (Continuation<T>) -> Any?): T =
//    suspendCoroutineUninterceptedOrReturn { cont -> block(cont.intercepted()) }
suspend fun suspendFunc02(a: String, b: String) = suspendCoroutine<Int> { continuation ->
    thread {
        log("执行block $b $continuation ,接着调用拦截continutaion的resume")
        continuation.resumeWith(Result.success(5)) // ... ①
    }
}

