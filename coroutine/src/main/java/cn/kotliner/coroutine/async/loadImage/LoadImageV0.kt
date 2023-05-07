package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//注意，这只是个普通方法，没有用suspend修饰，要与basic包类的Coroutines.kt的我要开始加载图片啦 方法区分开来
fun 我要开始加载图片啦普通方法(url: String): ByteArray {
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