package com.bennyhuo.kotlin.coroutines.sample.sample15

import com.bennyhuo.kotlin.coroutines.dispatcher.Dispatchers
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    val job = GlobalScope.launch(Dispatchers.Default) {
        log("日志1")
        withContext(Dispatchers.Android) {
            log("日志2")
            hello15()
        }
        log("日志4")
    }
    job.join()
    log("日志5")
}

suspend fun hello15() = suspendCoroutine<Int> {
    log("日志3")
    it.resume(10086)
}