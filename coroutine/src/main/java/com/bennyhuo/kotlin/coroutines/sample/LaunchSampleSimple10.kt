package com.bennyhuo.kotlin.coroutines.sample.sample10

import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.exception.coroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log
import java.lang.ArithmeticException

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log(coroutineContext[Job], "处理异常", throwable)
    }

    val job = GlobalScope.launch(exceptionHandler) {
        log("日志1")
        delay(1000)
        log("日志2")
        launch {
            throw ArithmeticException("Div 0")
        }
        log("日志3")
    }
    log(job.isActive)
    job.join()
}


