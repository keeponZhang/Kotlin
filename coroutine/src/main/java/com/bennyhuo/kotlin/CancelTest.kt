package com.bennyhuo.kotlin

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *createBy keepon
 * https://juejin.cn/post/6926695962354122765
 * https://blog.csdn.net/eclipsexys/article/details/120407669?spm=1001.2014.3001.5501
 */
fun main(args: Array<String>) = runBlocking<Unit> {
//    test1()


//    test2()
//    testException()
    val exceptionHandler =
            CoroutineExceptionHandler { coroutineContext, throwable ->
                log("xys", "---${coroutineContext}  ${throwable.printStackTrace()}")
            }
    GlobalScope.launch() {
        throw Exception("test")
    }
    log("----------")
}

suspend fun testException() {
    //自定义CoroutineExceptionHandler
    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("my coroutineExceptionHandler catch exception, msg = ${throwable.message}")
    }

    //handler有效
    val job = GlobalScope.launch(handler) {
        throw IndexOutOfBoundsException("exception thrown from launch")
    }
    job.start()

    //handler无效
    val deferred = GlobalScope.async(handler) {
        throw NullPointerException("exception thrown from async")
    }
//    deferred.start()
    try {
        deferred.await()
    } catch (e: Exception) {
        println("my deferred.await() catch exception")
//        Log.e("TAG", " testException []:") 
    }

    Thread.sleep(1000)
}

private suspend fun CoroutineScope.test2() {
    val job = launch {
        try {
            work()
        } catch (e: CancellationException) {
            println("Work cancelled!")
        } finally {
            println("Clean up!")
        }
    }
//    delay(1000L)
    println("Cancel!")
    job.cancel()
    println("Done!")
}

private suspend fun CoroutineScope.test1() {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("Hello ${i++}")
                nextPrintTime += 500L
            }
        }
    }
    delay(1000L)
    println("Cancel!")
    job.cancel()
    println("Done!")
}

fun work() {
}
