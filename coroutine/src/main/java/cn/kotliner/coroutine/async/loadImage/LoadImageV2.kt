package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

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
suspend fun 我要开始加载图片啦不切换线程异步(url: String) = suspendCoroutine<ByteArray> { continuation ->
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

