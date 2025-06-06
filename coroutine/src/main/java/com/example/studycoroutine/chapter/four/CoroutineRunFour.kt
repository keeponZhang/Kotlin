package com.example.studycoroutine.chapter.four

import com.example.studycoroutine.chapter.two.MyCoroutine
import kotlinx.coroutines.delay
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume

/**
 * Time:2025/6/6 17:44
 * Author:
 * Description:
 */
//com.example.studycoroutine.chapter.four.CoroutineRunFour.kt
suspend fun commonSuspendFun(): String {
    return "[hello world] "
}

suspend fun commonSuspendFun2(): String {

    return "[hello world 2]  "
}

suspend fun commonSuspendFun3(): String {

    return "[hello world 3]"
}

fun main() {
    testFunGetContinuation()
}

fun testFunGetContinuation() {

    val mystartSuspend: suspend () -> String = {
        //返回一个字符串hello world
        val one = commonSuspendFun()
        //返回一个字符串hello world2
        val two = commonSuspendFun2()
        //返回一个字符串hello world3
        val three = commonSuspendFun3()
        one + two + three
    }

    val myCoroutine = MyCoroutine()
//mystartSuspend.createCoroutine本质也是下面的调用不过封装了代理，不方便我们学习
    val createCoroutine = mystartSuspend.createCoroutine(myCoroutine)
    //val createCoroutine = mystartSuspend.createCoroutineUnintercepted(myCoroutine)

    createCoroutine.resume(Unit)
}
