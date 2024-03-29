package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.async
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log

suspend fun main() {
    log("日志1")
    val deferred = GlobalScope.async {
        log("日志2")
        delay(1000)
//        log执行在哪个线程，决定于是在哪里resume
        log("日志3")
        "Hello"
        throw ArithmeticException("Div 0")
    }
    log("日志4")
    try {
//        抛异常也当作是完成了
        val result = deferred.await()
        log("日志5", result)
    } catch (e: Exception) {
        log("日志6", e)
    }
}