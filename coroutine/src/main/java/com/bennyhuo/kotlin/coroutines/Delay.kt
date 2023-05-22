package com.bennyhuo.kotlin.coroutines

import com.bennyhuo.kotlin.coroutines.utils.log
import com.bennyhuo.kotlin.coroutines.cancel.delaySuspendCancellableCoroutine
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newScheduledThreadPool(1) { runnable ->
//    看不到把isDaemon改成非幽灵线程 false
    Thread(runnable, "Delay-Scheduler").apply { isDaemon = false }
}
suspend fun delayV0(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) =
    suspendCoroutine<Unit> { continuation ->
        log("执行到真正的block,continuation=$continuation")
        val future = executor.schedule(
            {
                log("delay代码执行,回调resume,continuation=$continuation-------------")
                continuation.resume(Unit)
            }, time, unit
        )
    }
suspend fun delay(time: Long, unit: TimeUnit = TimeUnit.MILLISECONDS) =
    delaySuspendCancellableCoroutine<Unit> { continuation ->
        log("执行到真正的block,continuation=$continuation")
        val future = executor.schedule(
            {
                log("delay代码执行,回调resume,continuation=$continuation-------------")
                continuation.resume(Unit)
            }, time, unit
        )
//            这里给delay任务增加取消回调,因为abstract用的是状态，当他是取消状态，这里会回调
        continuation.invokeOnCancelListener {
            log("delay执行future.cancel,取消任务")
            future.cancel(true)
        }
    }