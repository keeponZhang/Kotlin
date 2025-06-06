package com.example.studycoroutine.chapter.five

import com.bennyhuo.kotlin.coroutines.utils.log
import com.example.studycoroutine.chapter.two.MyCoroutine
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * Time:2025/6/6 18:16
 * Author:
 * Description:
 */
fun main() {
    testFiveOne()
}
//suspendCoroutineUninterceptedOrReturn
suspend fun mySuspendOne() = suspendCoroutineUninterceptedOrReturn<String> { continuation ->
    //传入的continuation就是SuspendLambda对象，也就是我们自己写一个lambda编译后的对象
    //启动一个线程。一秒后回调continuation函数
    thread {
        TimeUnit.SECONDS.sleep(1)
        log("mySuspendOne 我将调用Continuation返回一个数据")
        //调用又会重新调用BaseContinuationImpl的resumeWith函数
        continuation.resume("hello world")
    }

    log("mySuspendOne 函数返回")
    //因为我们这个函数没有返回正确结果，所以必须返回一个挂起标识,否则BaseContinuationImpl会认为完成了任务。
    // 并且我们的线程又在运行没有取消，这将很多意想不到的结果
    COROUTINE_SUSPENDED
}

suspend fun mySafeSuspendOne() = suspendCoroutine<String> { continuation ->

    //传入的continuation就是SuspendLambda对象，也就是我们自己写一个lambda编译后的对象
    //启动一个线程。一秒后回调continuation函数
    thread {
        TimeUnit.SECONDS.sleep(1)
        log("mySafeSuspendOne 我将调用Continuation返回一个数据")
        //调用又会重新调用BaseContinuationImpl的resumeWith函数
        continuation.resume("hello world ")
    }

    log("mySuspendOne 函数返回")
    //suspendCoroutine函数很聪明的帮我们判断返回结果如果不是想要的对象，自动返回kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED

}
fun testFiveOne() {
    val myCoroutine = MyCoroutine()
    val mystartSuspend: suspend () -> String = {
        mySuspendOne()
        mySafeSuspendOne()
    }

    //启动协程
    mystartSuspend.startCoroutine(myCoroutine)

    log("启动协程，由于两个挂起函数延迟返回结果所以这句话会先打出来")
}



