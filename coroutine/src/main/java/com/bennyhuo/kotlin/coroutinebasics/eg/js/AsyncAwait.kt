package com.bennyhuo.kotlin.coroutinebasics.eg.js

import android.os.Handler
import android.os.Looper
import com.bennyhuo.kotlin.coroutinebasics.api.githubApi
import com.bennyhuo.kotlin.coroutinebasics.common.Dispatcher
import com.bennyhuo.kotlin.coroutinebasics.common.DispatcherContext
import com.bennyhuo.kotlin.coroutines.utils.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.*

interface AsyncScope

suspend fun <T> AsyncScope.await(block: () -> Call<T>) = suspendCoroutine<T> {
    continuation ->
    val call = block()
    call.enqueue(object : Callback<T>{
        override fun onFailure(call: Call<T>, t: Throwable) {
            continuation.resumeWithException(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if(response.isSuccessful){
                response.body()?.let(continuation::resume) ?: continuation.resumeWithException(NullPointerException())
            } else {
                continuation.resumeWithException(HttpException(response))
            }
        }
    })
}
//这里直接开启了一个协程
fun async(context: CoroutineContext = EmptyCoroutineContext, block: suspend AsyncScope.() -> Unit) {
    val completion = AsyncCoroutine(context)
    //这里为什么需要传reciver，因为AsyncScope.()会转换成function1，把调用者传入，主要就是block需要
    block.startCoroutine(completion, completion)
}

class AsyncCoroutine(override val context: CoroutineContext = EmptyCoroutineContext): Continuation<Unit>, AsyncScope {
    override fun resumeWith(result: Result<Unit>) {
        //并不需要完成后做点什么，有异常就抛异常，无就算
        result.getOrThrow()
    }
}

