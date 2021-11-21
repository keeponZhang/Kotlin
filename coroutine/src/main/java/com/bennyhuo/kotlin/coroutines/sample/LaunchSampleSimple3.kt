package com.bennyhuo.kotlin.coroutines.sample


import com.bennyhuo.kotlin.coroutines.launch01
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    log("begin----------")
    val job = GlobalScope.launch01 {
        log("LaunchSampleSimple3 我是invokeSuspend")
        log("1")
        val result = withContext(Dispatchers.Default) {
            log("LaunchSampleSimple3 准备计算")
            5 + 5
        }
        log("LaunchSampleSimple3 继续往下执行2", result)
        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
    log("end----------")
    log("end----------")
}



