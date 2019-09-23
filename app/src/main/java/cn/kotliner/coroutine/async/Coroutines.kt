package cn.kotliner.coroutine.async

import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by benny on 5/29/17.
 */
//协程 suspend 修饰
fun 我要开始协程啦(context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    block.startCoroutine(ContextContinuation( context + AsyncContext()))
}

suspend fun <T> 我要开始耗时操作了(block: CoroutineContext.() -> T)
        = suspendCoroutine<T> {
    continuation ->
    log("我要开始耗时操作了 异步任务开始前")
    AsyncTask {
        try {
            continuation.resume(block(continuation.context))
        } catch(e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()
}

//注意，这只是个普通方法，没有用suspend修饰，要与basic包类的Coroutines.kt的我要开始加载图片啦 方法区分开来
fun 我要开始加载图片啦(url: String): ByteArray {
    log("异步任务开始前")
    log("耗时操作，下载图片")
    val responseBody = HttpService.service.getLogo(url).execute()
    if (responseBody.isSuccessful) {
        responseBody.body()?.byteStream()?.readBytes()?.let {
            //接注let方法返回，能保证返回的byteArray不为空
            return it
        }
        throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
    } else {
        throw HttpException(responseBody.code())
    }
}