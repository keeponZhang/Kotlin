package com.bennyhuo.kotlin.coroutines.sample.sample2

import com.bennyhuo.kotlin.coroutines.launchV2
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    log("begin----------")
    val job = GlobalScope.launchV2 {
        log("我是invokeSuspend")
        log("1")
        ""
//        val result = hello2()
//        log("继续往下执行2", result)
//        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
    log("end----------")
    log("end----------")
}

