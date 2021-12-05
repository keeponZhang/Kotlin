package com.bennyhuo.kotlin.coroutines.advanced.callback2suspend

import com.bennyhuo.kotlin.coroutines.advanced.common.gitHubServiceApi
import com.bennyhuo.kotlin.coroutines.advanced.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resumeWithException

suspend fun <T> Call<T>.await(): T = suspendCancellableCoroutine { continuation ->
    continuation.invokeOnCancellation {
//        响应取消
        cancel()
    }

    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            continuation.resumeWithException(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            response.takeIf { it.isSuccessful }
        }
    })
}

suspend fun main() {
//    test1()

    GlobalScope.launch {
        val user = gitHubServiceApi.getUserCallback("").await()
        log(user)
    }.cancelAndJoin()
}

suspend fun test1() {
    val user = gitHubServiceApi.getUserCallback("").await()
    log(user)
}


