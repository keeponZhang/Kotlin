package com.bennyhuo.kotlin.coroutines.sample


import com.bennyhuo.kotlin.coroutines.launch01
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    log("begin----------")
    val job = GlobalScope.launch01 {
        log("我是invokeSuspend")
        log("1")
        val result = hello2()
        log("继续往下执行2", result)
        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
    log("end----------")
    log("end----------")
}



suspend fun hello2() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread(isDaemon = true) {
        log("hello执行耗时任务")
        Thread.sleep(1000)
        log("hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}