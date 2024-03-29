package com.bennyhuo.kotlin.coroutines.sample

import com.bennyhuo.kotlin.coroutines.*
import com.bennyhuo.kotlin.coroutines.exception.CoroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.exception.coroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.scope.coroutineScope
import com.bennyhuo.kotlin.coroutines.scope.supervisorScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程，最一开始的$continuation是编译器传进来的
//block: suspend ()会生成一个BaseContinuationImpl，调用startCoroutine会调用create生成另一个BaseContinuationImpl，然后调用invokeSuspend
suspend fun main() {
    //test0()
    test0_1()
    //test1()
    //test2()
    //test3()
    //test4()
    //test5()
}

suspend fun test0() {
    val job = GlobalScope.launchV0 {
        log("我是invokeSuspend")
        log("1")
        val result = hello()
        log("继续往下执行2", result)
        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
}

suspend fun test0_1() {
    val job = GlobalScope.launchV1 {
        log("我是invokeSuspend")
        log("1")
        val result = hello()
        log("继续往下执行2", result)
        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
}


//挂起函数需要传一个Continution，所以挂起函数需要在协程或者挂起函数中调用
suspend fun test1() {
    val job = GlobalScope.launchV2 {
        log("我是invokeSuspend")
        log("1")
        val result = hello()
        log("继续往下执行2", result)
        result.toString()
    }
    log(job.isActive)
    job.join()
    log("end----------")
    log("end----------")
    log("end----------")
}


//挂起函数需要传一个Continution，所以挂起函数需要在协程或者挂起函数中调用
private suspend fun test2() {
    val job = GlobalScope.launch {
        log(1)
        val result = hello()
        log(2, result)
        delay(1000)
        log(3)
    }
    log(job.isActive)
//    cancel就进入join的状态
    job.cancel()
    job.join()
}

private suspend fun test3() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log(coroutineContext[Job], "处理异常", throwable)
    }

    val job = GlobalScope.launch(exceptionHandler) {
        log("1")
        delay(1000)
        val job2 = launch(exceptionHandler) {
            throw ArithmeticException("Div 0")
        }
        log(3)
        job2.join()
//        这里不会被执行，job2执行完抛异常，父协程把自己取消掉了
        log(4)
    }
    log(job.isActive)
    job.join()
}

private suspend fun test4() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log(coroutineContext[Job], "处理异常", throwable)
    }

    val job = GlobalScope.launch {
        log("test21", "1")
        val job2 = launch(exceptionHandler) {
        }
        job2.join()

    }
    Thread.sleep(2000)
    log(job.isActive)
    job.join()
}

private suspend fun test5() {
    val exceptionHandler = coroutineExceptionHandler { coroutineContext, throwable ->
//拿到的就是StandardCoroutine
        log(coroutineContext[Job], throwable)
    }

    val job = GlobalScope.launch(exceptionHandler) {
        log(1)
        delay(1000)
        supervisorScope {
            log(2)
            val job2 = launch(exceptionHandler) {
                throw ArithmeticException("Div 0")
            }
            log(3)
            job2.join()
            log(4)
        }
    }

    log(job.isActive)
    job.join()
}

suspend fun world() {

    coroutineScope {

    }
}

suspend fun hello() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread(isDaemon = true) {
        log("hello执行耗时任务")
        Thread.sleep(1000)
        log("hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}

suspend fun hello3() = suspendCoroutine<Int> {
//    是isDaemon有可能不会等待
    thread(isDaemon = true) {
        log("hello执行耗时任务")
        Thread.sleep(1000)
        log("hello恢复 $it ,这里的会回调到系统的SafeContinuation")
        it.resume(10086)
    }
}