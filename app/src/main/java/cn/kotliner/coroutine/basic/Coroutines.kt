package cn.kotliner.coroutine.basic

import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.startCoroutine
import kotlin.coroutines.experimental.suspendCoroutine

/**
 * Created by benny on 5/29/17.
 */
fun 我要basic开始协程啦(block: suspend () -> Unit) {
    block.startCoroutine(BaseContinuation())
}

// suspendCoroutine<ByteArray> 泛型参数表示想要的数据结果类型
suspend fun 我要开始basic加载图片啦(url: String) = suspendCoroutine<ByteArray> { continuation ->
    log("耗时操作，下载图片")
    try {
        val responseBody = HttpService.service.getLogo(url).execute()
        if (responseBody.isSuccessful) {
            //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
            responseBody.body()?.byteStream()?.readBytes()?.let(continuation::resume)
        } else {
            continuation.resumeWithException(HttpException(responseBody.code()))
        }
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}