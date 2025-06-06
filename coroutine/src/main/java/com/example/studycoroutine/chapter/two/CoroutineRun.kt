package com.example.studycoroutine.chapter.two

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine

/**
 * Time:2025/6/6 17:03
 * Author:
 * Description:
 */
//com.example.studycoroutine.chapter.two.CoroutineRunFour.kt
suspend fun mySuspendFun(): String {
    return "hello";
}
fun main() {
    testOne()
}

fun testOne() {
    //这个是block调用，相当于一个闭包，可以传入参数，也可以返回结果，这里是无参，也没有接收者
    val myCoroutineFun: suspend () -> String = {
        log("返回 hello结果")
        mySuspendFun()

    }

    val myCoroutine = MyCoroutine()
    val coroutine = myCoroutineFun.startCoroutine(myCoroutine)

}




