package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.exception.CoroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.launch0
import com.bennyhuo.kotlin.coroutines.launch01
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.scope.coroutineScope
import com.bennyhuo.kotlin.coroutines.scope.supervisorScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    val job = GlobalScope.launch {
        log("日志1")
        val result = hello()
        log("日志2", result)
        delay(20000)
        log("日志3")
    }
    log(job.isActive)
//    cancel就进入join的状态
    job.cancel()
    job.join()
    log("日志4")
}



suspend fun hello4() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread(isDaemon = true) {
        log("LaunchSampleSimple4 hello执行耗时任务")
        Thread.sleep(1000)
        log("LaunchSampleSimple4 hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}