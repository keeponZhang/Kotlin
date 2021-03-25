package com.example.retrofittest

import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {
    test1()
    test2()
    Thread.sleep(1000)
//    val start = System.currentTimeMillis()
//    runBlocking {
//        repeat(100000) {
//            launch {
//                println(".")
//            }
//        }
//    }
//    val end = System.currentTimeMillis()
//    println(end - start)
//
//    val job = Job()
//    val scope = CoroutineScope(job)
//    scope.launch {
//        // do something
//    }
//    job.cancel()


//    ，coroutineScope函数和runBlocking函数还有点类似，它可以保证其作用域内的所
//    有代码和子协程在全部执行完之前，外部的协程会一直被挂起
//    runBlocking {
//        coroutineScope {
//            launch {
//                for (i in 1..10) {
//                    println(i)
//                    delay(1000)
//                }
//            }
//        }
//        println("coroutineScope finished")
//    }
//    println("runBlocking finished")

//    runBlocking {
//        val start = System.currentTimeMillis()
//        val deferred1 = async {
//            delay(1000)
//            5 + 5
//        }
//        val deferred2 = async {
//            delay(1000)
//            4 + 6
//        }
//        println("result is ${deferred1.await() + deferred2.await()}.")
//        val end = System.currentTimeMillis()
//        println("cost ${end - start} milliseconds.")
//    }

//    runBlocking {
//        getAppData()
//    }
}

private fun test1() {
    GlobalScope.launch {
        println("codesrun in coroutine scope")

    }
}

private fun test2() {
    GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")

    }
}

private fun test3() {
    runBlocking {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")

    }
}

// = 号会报错
//suspend fun printDot0() = {
//    println(".")
//    delay(1000)
//}

suspend fun printDot() {
    println(".")
    delay(1000)
}

//可以借用coroutineScope
//虽然看上去coroutineScope函数和runBlocking函数的作用是有点类似的，但是
//coroutineScope函数只会阻塞当前协程，既不影响其他协程，也不影响任何线程，因此是不
//会造成任何性能上的问题的。而runBlocking函数由于会挂起外部线程，如果你恰好又在主线
//程中当中调用它的话，那么就有可能会导致界面卡死的情况，所以不太推荐在实际项目中使
//用。
suspend fun printDot1() = coroutineScope {
    println(".")
    delay(1000)
}

suspend fun getAppData() {
    try {
        val appList = ServiceCreator.create<AppService>().getAppData()
            .await() // 这段代码想运行通过，需要将BASE_URL中的地址改成http://localhost/
        println(appList)
        // 对服务器响应的数据进行处理
    } catch (e: Exception) {
        // 对异常情况进行处理
        e.printStackTrace()
    }
}

suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) continuation.resume(body)
                else continuation.resumeWithException(RuntimeException("response body is null"))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}