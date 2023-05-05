package cn.kotliner.coroutine.p000ui.mainkt2;

import cn.kotliner.coroutine.common.HttpException;
import cn.kotliner.coroutine.common.HttpService;
import cn.kotliner.coroutine.common.LogKt;
import cn.kotliner.coroutine.ui.MainWindow;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.SafeContinuation;
import kotlin.coroutines.experimental.jvm.internal.CoroutineIntrinsics;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 2, d1 = {"��\u001e\n��\n\u0002\u0010\u0012\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0011\n\u0002\b\u0005\u001a\u0019\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\t\u001a\u0006\u0010\n\u001a\u00020\u0006\u001a\u0011\u0010\u000b\u001a\u00020\u0006H\u0086@ø\u0001��¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\t¨\u0006\r"}, d2 = {"getPicSyn", "", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "main", "", "args", "", "([Ljava/lang/String;)V", "test2", "testsuspend", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;", "app_debug"})
/* renamed from: cn.kotliner.coroutine.ui.mainkt2.Mainkt2_1Kt */
/* loaded from: Mainkt2_1Kt.class */
public final class Mainkt2_1 {
    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
        MainWindow frame = new MainWindow();
        frame.setTitle("Coroutine@Bennyhuo");
        frame.setSize(200, 150);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(3);
        frame.init();
        frame.setVisible(true);
        frame.onButtonClick(new Mainkt2_1Kt$main$1(frame));
    }

    @Nullable
    public static final Object testsuspend(@NotNull Continuation<? super Unit> continuation) {
        System.out.println((Object) "suspend test");
        return Unit.INSTANCE;
    }

    public static final void test2() {
        System.out.println((Object) "test2");
    }

    @Nullable
    public static final Object getPicSyn(@NotNull String url, @NotNull Continuation<? super byte[]> continuation) {
        Continuation c$iv = CoroutineIntrinsics.normalizeContinuation(continuation);
        Continuation safeContinuation = new SafeContinuation(c$iv);
        LogKt.log("耗时操作，下载图片原始0" + safeContinuation);
        try {
            final Continuation continuation2 = safeContinuation;
            HttpService.INSTANCE.getService().getLogo(url).enqueue(new Callback<ResponseBody>() { // from class: cn.kotliner.coroutine.ui.mainkt2.Mainkt2_1Kt$getPicSyn$2$1
                public void onFailure(@Nullable Call<ResponseBody> call, @Nullable Throwable t) {
                    LogKt.log("返回结果onFailure");
                }

                public void onResponse(@Nullable Call<ResponseBody> call, @Nullable Response<ResponseBody> response) {
                    byte[] p1;
                    LogKt.log("返回结果");
                    if (response != null) {
                        if (response.isSuccessful()) {
                            ResponseBody responseBody = (ResponseBody) response.body();
                            if (responseBody != null) {
                                InputStream byteStream = responseBody.byteStream();
                                if (byteStream != null && (p1 = ByteStreamsKt.readBytes$default(byteStream, 0, 1, (Object) null)) != null) {
                                    continuation2.resume(p1);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        continuation2.resumeWithException(new HttpException(response.code()));
                    }
                }
            });
        } catch (Exception e) {
            safeContinuation.resumeWithException(e);
        }
        return safeContinuation.getResult();
    }
}