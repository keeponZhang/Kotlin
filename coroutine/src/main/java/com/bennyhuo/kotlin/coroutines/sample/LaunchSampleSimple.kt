package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.exception.coroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log


//响应取消的是响应调用的协程
suspend fun main() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log(coroutineContext[Job], "处理异常", throwable)
    }

    val job = GlobalScope.launch() {
        log("1")
        delay(1000)
        val job2 = launch(exceptionHandler) {
//            异常在BaseContinuationImpl中的invokeSuspend捕获的
            throw ArithmeticException("Div 0")
        }
        log(3)
//        这里不会被执行，job2执行完抛异常，父协程把自己取消掉了
        log(4)
    }
    log(job.isActive)
    job.join()
}


