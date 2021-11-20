package com.bennyhuo.kotlin.coroutines.sample.sample5

import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
//   1.开启协程，
    val job = GlobalScope.launch {
        log("日志1")
        delay(1000)
        log("日志2")
    }
    log("日志job.isActive=${job.isActive}")
//    cancel就进入join的状态
//    job.cancel()
    log("准备调用join")
    job.join()
//    日志4这里是跟日志2一个线程，因为这里没有恢复协程时，直接继续执行了
    log("日志4")
}



