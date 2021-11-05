package cn.kotliner.coroutine.async.Coroutines2_simple.kt

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.async.UiCotinuationWrapper
import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log

import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *createBy keepon
 */
/**
 * 会这样调用CoroutineIntrinsics.normalizeContinuation($completion); completion:CoroutineImpl
 * suspendCoroutine可以拿到编译器的continuation，进行回调 又会创建一个SafeContinuation.getResult，返回结果，接着回到协程继续执行
 */
suspend fun 我要开始加载图片啦不切换线程同步2_0_simple(url: String): ByteArray =
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

suspend fun 我要开始加载图片啦不切换线程同步2_0_simple2(url: String): String = "keepon"


//suspend fun 我要开始加载图片啦不切换线程同步2_0_simple(url: String): ByteArray
//相当于  fun 我要开始加载图片啦不切换线程同步2_0_simple(url: String,continutaion:Continuation<ByteArray>): ByteArray

//public suspend inline fun <T> suspendCoroutine(crossinline block: (Continuation<T>) -> Unit): T =
//    suspendCoroutineUninterceptedOrReturn { c: Continuation<T> ->
//        val safe = SafeContinuation(c.intercepted())
//        block(safe)
//        safe.getOrThrow()
//    }


//方法调用顺序
//suspendCoroutine->Continuation.suspendCoroutineUninterceptedOrReturn->suspendCoroutineOrReturn


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
