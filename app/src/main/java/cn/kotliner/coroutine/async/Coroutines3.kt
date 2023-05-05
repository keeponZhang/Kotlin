package cn.kotliner.coroutine.async.coroutines3

import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.suspendCoroutine


suspend fun coroutines3Test(url: String): ByteArray =
    suspendCoroutine<ByteArray> { continuation ->
        log("耗时操作，下载图片原始0")

        try {
            //这里是用的同步方法
            val responseBody = HttpService.service.getLogo(url).execute()
            log("耗时操作，下载图片ing")
            if (false && responseBody.isSuccessful) {
                //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                // ，注意continuation为SafeContinuation，为SafeContinuation的result
                // 赋值，接着会调用SafeContinuation的
                responseBody.body()?.byteStream()?.readBytes()?.let(continuation::resume)
            } else {
                continuation.resumeWithException(HttpException(responseBody.code()))
            }
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }


    }





