package com.bennyhuo.kotlin.coroutinebasics.core

import android.util.Log
import com.bennyhuo.kotlin.coroutinebasics.api.User
import com.bennyhuo.kotlin.coroutinebasics.api.githubApi
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.RuntimeException

import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun foo() {}

//像这种不是真正的挂起函数
suspend fun bar(a: Int): String {
    return "Hello"
}

//fun foo(continuation: Continuation<Unit>): Any{}
//
//fun bar(a: Int, continuation: Continuation<String>): Any{
//    return "Hello"
//}

//真正的挂起必须异步调用resume：包括切到其他线程resume，单线程事件循环异步执行
//suspendCoroutine可以拿到编译器传的continuation
suspend fun getUserSuspend(name: String) = suspendCoroutine<User> { continuation ->
    githubApi.getUserCallback(name).enqueue(object : Callback<User> {
        override fun onFailure(call: Call<User>, t: Throwable) =
            continuation.resumeWithException(t)

        override fun onResponse(call: Call<User>, response: Response<User>) =
//            response.takeIf { it.isSuccessful }?.body()?.let(continuation::resume)
//                ?: continuation.resumeWithException(HttpException(response))

            continuation.resumeWithException(HttpException(response))
    })
}

private val supervisor = SupervisorJob()
fun main() {
    runBlocking {
//        try {
//            val user = getUserSuspend("bennyhuo")
//        } catch (e: Exception) {
//            println("-------getUserSuspend Exception-----")
//        }
//        val deffer = async {
//            try {
//                getUserSuspend("bennyhuo2")
//            } catch (e: Exception) {
//                println("async exception")
//            }
//
//        }
//        try {
//            val await = deffer.await()
//            println(" await $await")
//        } catch (e: Exception) {
//            println("-------deffer Exception-----")
//        }

        val deffer2 = async {
            try {
                githubApi.getUserSuspend("bennyhuo2")
            } catch (e: Exception) {
                println("deffer2 exception")
            }

        }.await()
        val deffer3 = async(supervisor) {
            try {
                githubApi.getUserSuspend("bennyhuo3")
            } catch (e: Exception) {
                println("deffer3 exception")
            }

        }.await()
//        val await2 = deffer2.await()
//        当 async 在根协程 (CoroutineScope 实例或者 supervisorJob 的直接子协程) 使用时，异常不会被自动抛出，而是直到你调用 .await() 时才抛出。
        supervisorScope {
            val deferred4 = async {
                throw RuntimeException("keepon")
//                githubApi.getUserCallback("keepon").execute()
//                githubApi.getUserSuspend("keepo2n")
            }
            try {
//                val await4 = deferred4.await()
//                println("------------ await4 ${await4.body()?.name}")
            } catch (e: Exception) {
                println("deffer4 exception")
            }
        }
        println("------------end--")
    }

//    showUser(user)
//
//    suspend {
//
//    }.createCoroutine(object : Continuation<Unit> {
//        override val context = EmptyCoroutineContext
//
//        override fun resumeWith(result: Result<Unit>) {
//            log("Coroutine End with $result")
//        }
//    }).resume(Unit)
//
//    suspend {
//
//    }.startCoroutine(object : Continuation<Unit> {
//        override val context = EmptyCoroutineContext
//
//        override fun resumeWith(result: Result<Unit>) {
//            log("Coroutine End with $result")
//        }
//    })
//
//    suspend {
//
//    }.startCoroutine(object : Continuation<Unit> {
//        override val context = DispatcherContext(HandlerDispatcher)
//
//        override fun resumeWith(result: Result<Unit>) {
//            log("Coroutine End with $result")
//        }
//    })
//
//    suspend {
//
//    }.startCoroutine(object : Continuation<Unit> {
//        override val context = DispatcherContext(HandlerDispatcher)
//
//        override fun resumeWith(result: Result<Unit>) {
//            log("Coroutine End with $result")
//        }
//    })
}

suspend fun suspendFunc() = suspendCoroutine<Int> {
    it.resumeWith(Result.success(1))
}