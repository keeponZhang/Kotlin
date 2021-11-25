package com.bennyhuo.kotlin.coroutine.ch03

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//suspend main 是createCoroutineFromSuspendFunction，里面已经重写了invokeSuspend方法
fun main() {
    runSuspend {
        val continuation = suspend {
            val hello4 = hello4()
            log("日志2 $hello4")
            5
        }.createCoroutine(object : Continuation<Int> {
            override fun resumeWith(result: Result<Int>) {
                log("Coroutine End: $result")
            }

            override val context = EmptyCoroutineContext
        }).resume(Unit)
//    delay(5000)
        log("-----日志---------")
    }
    log("end")
}

suspend fun hello4() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread(isDaemon = true) {
        log("LaunchSampleSimple4 日志hello执行耗时任务")
        Thread.sleep(1000)
        log("LaunchSampleSimple4 日志hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}