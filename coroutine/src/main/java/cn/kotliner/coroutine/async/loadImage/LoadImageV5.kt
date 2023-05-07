package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.async.UiCotinuationWrapper
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//UiCotinuationWrapper把切线程封装起来
//ByteArray表示你想要的数据结果，continuation是suspendCoroutine里面传入的SafeContinuation
suspend fun 我要开始加载图片啦UiCotinuationWrapper(url: String) =
    suspendCoroutine<ByteArray> { continuation ->
        log("耗时操作，下载图片原始0")
        val uiCotinuationWrapper = UiCotinuationWrapper(continuation)
        AsyncTask() {
            try {
                val responseBody = HttpService.service.getLogo(url).execute()
                log("耗时操作，下载图片ing")
                if (responseBody.isSuccessful) {
                    //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                    responseBody.body()?.byteStream()?.readBytes()?.let {
                        uiCotinuationWrapper.resume(it)
                    }
                } else {
                    uiCotinuationWrapper.resumeWithException(
                        HttpException(responseBody.code())
                    )
                }
            } catch (e: Exception) {
                uiCotinuationWrapper.resumeWithException(e)
            }
        }.execute()

    }
