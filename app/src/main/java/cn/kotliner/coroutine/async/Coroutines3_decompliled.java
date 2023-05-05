//package cn.kotliner.coroutine.async;
//
//import androidx.annotation.Nullable;
//
//import org.jetbrains.annotations.NotNull;
//
//
//import cn.kotliner.coroutine.basic.BaseContinuation;
//import cn.kotliner.coroutine.common.HttpException;
//import cn.kotliner.coroutine.common.HttpService;
//import cn.kotliner.coroutine.common.LogKt;
//import kotlin.Unit;
//import kotlin.coroutines.experimental.Continuation;
//import kotlin.coroutines.experimental.CoroutineContext;
//import kotlin.coroutines.experimental.EmptyCoroutineContext;
//import kotlin.coroutines.experimental.SafeContinuation;
//import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
//import kotlin.jvm.functions.Function1;
//import kotlin.jvm.internal.Intrinsics;
//import retrofit2.Response;
//
///**
// * Time:2023-05-04 下午 11:41
// * Author:
// * Description:
// * /Users/keeponzhang/Downloads/study/codeWorkSpace/mycode/keeponGitgub/Kotlin/kotlin-stdlib-1_2_51
// * /Users/keeponzhang/Downloads/study/codeWorkSpace/mycode/keeponGitgub/Kotlin/kotlin-stdlib-common-1_2_51
// * /Users/keeponzhang/Downloads/study/codeWorkSpace/mycode/keeponGitgub/Kotlin/kotlin-stdlib-jdk7-1_2_51
// */
//class Coroutines3_decompliled {
//    @Nullable
//    public static final Object coroutines3Test(@NotNull String url, @NotNull Continuation<? super byte[]> continuation) {
//        Continuation c$iv = CoroutineIntrinsics.normalizeContinuation(continuation);
//        Continuation safeContinuation = new SafeContinuation(c$iv);
//        LogKt.log("耗时操作，下载图片原始0");
//        try {
//            Response responseBody = HttpService.INSTANCE.getService().getLogo(url).execute();
//            LogKt.log("耗时操作，下载图片ing");
//            safeContinuation.resumeWithException(new HttpException(responseBody.code()));
//        } catch (Exception e) {
//            safeContinuation.resumeWithException(e);
//        }
//        return safeContinuation.getResult();
//    }
//
//}
