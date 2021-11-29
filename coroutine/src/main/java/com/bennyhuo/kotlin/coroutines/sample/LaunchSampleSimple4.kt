package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    test3()
}

fun test3() {
    val job = GlobalScope.launch(Dispatchers.Main) {
        log("日志1")
        log("日志1.2")
//        val result = hello4()
        withContext(Dispatchers.IO) {
            log("日志1.3")
        }
//        这里基本不会执行到
        log("日志2", "5")
        delay(2000)
        log("日志3")
    }
    log(job.isActive)
//    cancel就进入join的状态
//    job.cancel()
    log("日志4")
}

suspend fun hello4() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread() {
        log("LaunchSampleSimple4 日志hello执行耗时任务")
        Thread.sleep(2000)
        log("LaunchSampleSimple4 日志hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}