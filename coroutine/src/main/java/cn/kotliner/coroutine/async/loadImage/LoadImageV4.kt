package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import javax.swing.SwingUtilities
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//这里resume的时候切换回主线程
suspend fun 我要开始加载图片啦切换线程AsyTask(url: String) =
    suspendCoroutine<ByteArray> { continuation ->
        log("耗时操作，下载图片原始0" + continuation)
        AsyncTask() {
            try {
                val responseBody = HttpService.service.getLogo(url).execute()
                log("耗时操作，下载图片ing")
                if (responseBody.isSuccessful) {
                    //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                    responseBody.body()?.byteStream()?.readBytes()?.let {
                        SwingUtilities.invokeLater { continuation.resume(it) }

                    }
                } else {
                    continuation.resumeWithException(HttpException(responseBody.code()))
                }
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }.execute()

    }
