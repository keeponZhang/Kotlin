package com.blog.sili

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * createBy	 keepon
 */
@InternalCoroutinesApi
suspend fun main() {

    //启动一个懒启动 CoroutineStart.LAZY用说明isActive不一定
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        //获取当前的上下文
        TimeUnit.MILLISECONDS.sleep(500)
        log("协程完成")
    }

    log("未启动协程之前的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")
    job.start()
    log("启动协程之后的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")
    TimeUnit.MILLISECONDS.sleep(500)
    log("启动协程完成之后的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")

    TimeUnit.HOURS.sleep(1)
    test1()
}

@InternalCoroutinesApi
suspend fun test1() {
    //启动一个懒启动 CoroutineStart.LAZY用说明isActive不一定
    val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        //获取当前的上下文
        TimeUnit.MILLISECONDS.sleep(500)
        log("协程完成")
    }

    log("未启动协程之前的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")
    job.start()
    log("启动协程之后的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")
    job.cancel()
    log("启动协程取消之后的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")
    job.join()
    log("启动协程取消并且之后的状态: isActive: [${job.isActive}]  isCompleted: [${job.isCompleted}]  isCancelled: [${job.isCancelled}] ")

    TimeUnit.HOURS.sleep(1)
    job.invokeOnCompletion(onCancelling = false, invokeImmediately = false) {
        log("取消的回调" + it)
    }
//    invokeImmediately参数主要用于监听已经完成协程时是否回调,如果为false 那么如果在添加监听事件时协程已经完成或取消那么将不会回调.
}
