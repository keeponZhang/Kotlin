package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.async
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log

suspend fun main() {
    log(1)
    val deferred = GlobalScope.async {
        log(2)
        delay(1000)
//        log执行在哪个线程，决定于是在哪里resume
        log(3)
        "Hello"
        throw ArithmeticException("Div 0")
    }
    log(4)
    try {
//        抛异常也当作是完成了
        val result = deferred.await()
        log(5, result)
    } catch (e: Exception) {
        log(6, e)
    }
}