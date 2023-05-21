package com.bennyhuo.kotlin.coroutines.sample.sample6

import com.bennyhuo.kotlin.coroutines.launch

import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log


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



