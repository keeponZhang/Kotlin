package cn.kotliner.coroutine.async.Coroutines2.kt

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.async.UiCotinuationWrapper
import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.intrinsics.suspendCoroutineOrReturn
import kotlin.coroutines.experimental.suspendCoroutine

/**
 *createBy keepon
 */
/**
 * suspendCoroutine可以拿到编译器的continuation，进行回调 又会创建一个SafeContinuation
 */
suspend fun 我要开始加载图片啦不切换线程同步2_0(url: String) =
    suspendCoroutine<ByteArray> { continuation ->
        log("耗时操作，下载图片原始0")

        try {
            //这里是用的同步方法
            val responseBody = HttpService.service.getLogo(url).execute()
            log("耗时操作，下载图片ing")
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


//continuation是Safecontinuation
//suspendCoroutine->suspendCoroutineOrReturn,目的是返回T,suspendCoroutineOrReturn的参数是block
//suspendCoroutineUninterceptedOrReturn也是接收一个block参数，
//参数先传到suspendCoroutineUninterceptedOrReturn的cont（最原始的编译器的continuation，CoroutineImpl），做了cont.intercepted()
// 运算后又传到suspendCoroutineOrReturn，有创造了SafeContinuation，传到suspendCoroutine<ByteArray> {
// continuation->}中的continuation

//反编译
//@Nullable
//public static final Object 我要开始加载图片啦不切换线程异步2_1(@NotNull String url, @NotNull Continuation $completion) {
//    int $i$f$suspendCoroutine = false;
//    boolean var3 = false;
//    boolean var5 = false;
//    Continuation var7 = CoroutineIntrinsics.normalizeContinuation($completion);
//    int var9 = false;
//    SafeContinuation safe$iv = new SafeContinuation(var7);
//    Continuation continuation = (Continuation)safe$iv;
//    int var12 = false;
//    LogKt.log("耗时操作，下载图片原始0" + continuation);
//
//    try {
//        HttpService.INSTANCE.getService().getLogo(url).enqueue((Callback)(new CoroutinesKt$我要开始加载图片啦不切换线程异步2_1$2$1(continuation)));
//    } catch (Exception var14) {
//        continuation.resumeWithException((Throwable)var14);
//    }
//
//    return safe$iv.getResult();
//}
suspend fun 我要开始加载图片啦不切换线程异步2_1(url: String) = suspendCoroutine<ByteArray> { continuation ->
    log("耗时操作，下载图片原始0" + continuation)

    try {
        //这里是用的同步方法
        HttpService.service.getLogo(url).enqueue(object : Callback<ResponseBody> {

            override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                TODO(
                    "not implemented") //To change body of created functions use File | Settings | File Templates.
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

suspend fun 我要开始加载图片啦不切换线程AsyTask_2_2(url: String) =
    suspendCoroutine<ByteArray> { continuation ->
        log("耗时操作，下载图片原始0")
        AsyncTask() {
            try {
                val responseBody = HttpService.service.getLogo(url).execute()
                log("耗时操作，下载图片ing")
                if (responseBody.isSuccessful) {
                    //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                    responseBody.body()?.byteStream()?.readBytes()
                        ?.let(continuation::resume)
                } else {
                    continuation.resumeWithException(HttpException(responseBody.code()))
                }
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }.execute()

    }

suspend fun 我要开始加载图片啦切换线程AsyTask_2_3(url: String) =
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


//ByteArray表示你想要的数据结果，continuation是suspendCoroutine里面传入的SafeContinuation
suspend fun 我要开始加载图片啦Uicontinuation2_4(url: String) =
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
                        HttpException(responseBody.code()))
                }
            } catch (e: Exception) {
                uiCotinuationWrapper.resumeWithException(e)
            }
        }.execute()

    }

//CoroutineContext.()相当于（CoroutineContext）
suspend fun <T> 我要开始耗时操作了4(block: CoroutineContext.() -> T) =
    suspendCoroutine<T> { continuation ->
        log("我要开始耗时操作了 异步任务开始前")
        AsyncTask {
            try {
                //这样写的好处是已经给block传入了默认的输入参数，block里面只需要处理返回值，就是返回T
                //这里传context，其实是因为context里面可以带变量
                continuation.resume(block(continuation.context))
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }.execute()
    }

suspend fun 我要开始加载图片啦3(url: String) = suspendCoroutine<ByteArray> { continuation ->
    log("耗时操作，下载图片原始0")
    AsyncTask() {
        try {
            val responseBody = HttpService.service.getLogo(url).execute()
            log("耗时操作，下载图片ing")
            if (responseBody.isSuccessful) {
                //把读到的ByteArray结果传给continuation::resume，通过resume把byteArray传出去
                responseBody.body()?.byteStream()?.readBytes()?.let {
                    continuation.resume(it)
                }
            } else {
                continuation.resumeWithException(HttpException(responseBody.code()))
            }
        } catch (e: Exception) {
            continuation.resumeWithException(e)
        }
    }.execute()

}




//注意，这只是个普通方法，没有用suspend修饰，要与basic包类的Coroutines.kt的我要开始加载图片啦 方法区分开来
fun 我要开始加载图片啦4_(url: String): ByteArray {
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



