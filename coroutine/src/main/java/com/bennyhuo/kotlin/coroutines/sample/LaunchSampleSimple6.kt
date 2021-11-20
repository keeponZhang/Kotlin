package com.bennyhuo.kotlin.coroutines.sample.sample5

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
//   1.开启协程，
    //   1.开启协程，
    val job = GlobalScope.launch {
        log("日志1")
    }
    log("日志job.isActive=${job.isActive}")
//    cancel就进入join的状态
    job.cancel()
    log("准备调用join")
    job.join()
    log("日志4")
}



