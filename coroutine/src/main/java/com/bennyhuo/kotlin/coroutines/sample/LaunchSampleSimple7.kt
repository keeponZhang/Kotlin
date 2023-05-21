package com.bennyhuo.kotlin.coroutines.sample.sample7

import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log
import java.lang.ArithmeticException


//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    val job = GlobalScope.launch {
        log("日志1")
        delay(1000)
        log("日志2")
        throw ArithmeticException("Div 0")
        log("日志3")
    }
    log(job.isActive)
    job.join()
}



