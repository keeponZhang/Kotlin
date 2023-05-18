package com.bennyhuo.kotlin.coroutines.sample.sample5

import com.bennyhuo.kotlin.coroutines.exception.coroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.ContextScope
import com.bennyhuo.kotlin.coroutines.scope.supervisorScope
import com.bennyhuo.kotlin.coroutines.utils.log

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log("处理异常")
    }
    val exceptionHandler2 = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log("处理异常2")
    }
    val coroutineScope = ContextScope(kotlin.coroutines.EmptyCoroutineContext)
    val job = coroutineScope.launch(exceptionHandler) {
//        其实就是能拿到scopeContext，即是当前的context
        log("日志1:$scopeContext")
        supervisorScope {
            val launch = launch(exceptionHandler2) {
                log("日志1.2:$scopeContext")
                1 / 0
            }
            log("日志2:$scopeContext")
            launch.join()
//            这个还能接着执行，因为没有被取消
            log("日志3:$scopeContext")
        }
    }
    log(job.isActive)
    job.join()
}



