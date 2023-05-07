package cn.kotliner.coroutine.async.Coroutines2.kt

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.async.UiCotinuationWrapper
import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.SwingUtilities
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun 我要开始加载图片啦不切换线程异步2_3(url: String) = suspendCoroutine<ByteArray> { continuation ->
    log("耗时操作，下载图片原始0" + continuation)

    try {
        //这里是用的同步方法
        HttpService.service.getLogo(url).enqueue(object : Callback<ResponseBody> {

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                TODO(
                    "not implemented"
                ) //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ResponseBody>?, response: Response<ResponseBody>?
            ) {
                log("返回结果")
                if (response != null) {
                    if (response.isSuccessful) {
                        //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                        response.body()?.byteStream()?.readBytes()?.let(continuation::resume)
                    } else {
                        continuation.resumeWithException(HttpException(response.code()))
                    }
                }
            }
        })
    } catch (e: Exception) {
        continuation.resumeWithException(e)
    }
}



