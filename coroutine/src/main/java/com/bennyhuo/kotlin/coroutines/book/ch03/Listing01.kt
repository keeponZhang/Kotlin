package com.bennyhuo.kotlin.coroutine.ch03

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine

//suspend main 是createCoroutineFromSuspendFunction，里面已经重写了invokeSuspend方法
suspend fun main() {
    val continuation = suspend {
//        delay(5000)
        Thread.sleep(500)
        println("In Coroutine.")
        5
    }.createCoroutine(object : Continuation<Int> {
        override fun resumeWith(result: Result<Int>) {
            println("Coroutine End: $result")
        }

        override val context = EmptyCoroutineContext
    })
    log("1")
    delay(5000)
    log("2")
}