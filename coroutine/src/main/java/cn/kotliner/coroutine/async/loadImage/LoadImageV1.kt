package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Time:2023-05-07 下午 6:20
 * Author:
 * Description:
 */
/**
 *createBy keepon
 */
/**
 * 会这样调用CoroutineIntrinsics.normalizeContinuation($completion); completion:CoroutineImpl
 * suspendCoroutine可以拿到编译器的continuation，进行回调 又会创建一个SafeContinuation.getResult，返回结果，接着回到协程继续执行
 *
 * continuation是SafeContinuation，恢复的时候使用
 */
suspend fun 我要开始加载图片啦不切换线程同步(url: String): ByteArray =
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
