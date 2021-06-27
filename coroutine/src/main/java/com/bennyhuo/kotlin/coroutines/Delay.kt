package com.bennyhuo.kotlin.coroutines

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import com.bennyhuo.kotlin.coroutines.cancel.suspendCancellableCoroutine
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume

private val executor = Executors.newScheduledThreadPool(1) { runnable ->
//    看不到把isDaemon改成非幽灵线程 false
    Thread(runnable, "Delay-Scheduler").apply { isDaemon = false }
}

suspend fun delay(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) =
        suspendCancellableCoroutine<Unit> { continuation ->
            log("调用delay")
            val future = executor.schedule(
                    {
                        log("delay代码执行")
                        continuation.resume(Unit)
                    }, time, unit)
//            这里给delay任务增加取消回调
            continuation.invokeOnCancel {
                log("Delay 取消执行future.cancel")
                future.cancel(true)
            }
        }