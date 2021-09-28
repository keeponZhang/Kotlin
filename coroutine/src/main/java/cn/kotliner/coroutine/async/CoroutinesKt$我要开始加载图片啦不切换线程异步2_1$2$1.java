package cn.kotliner.coroutine.async;// package cn.kotliner.coroutine.async;
//



//
// public static final Object 我要开始加载图片啦不切换线程异步2_1(@NotNull String url, @NotNull Continuation $completion) {
//         int $i$f$suspendCoroutine = false;
//         boolean var3 = false;
//         boolean var5 = false;
//         Continuation var7 = CoroutineIntrinsics.normalizeContinuation($completion);
//         int var9 = false;
//         SafeContinuation safe$iv = new SafeContinuation(var7);
//         Continuation continuation = (Continuation)safe$iv;
//         int var12 = false;
//         LogKt.log("耗时操作，下载图片原始0" + continuation);
//
//         try {
//         HttpService.INSTANCE.getService().getLogo(url).enqueue((Callback)(new CoroutinesKt$我要开始加载图片啦不切换线程异步2_1$2$1(continuation)));
//         } catch (Exception var14) {
//         continuation.resumeWithException((Throwable)var14);
//         }
//
//         return safe$iv.getResult();
//         }










// public final class CoroutinesKt$我要开始加载图片啦不切换线程异步2_1$2$1 implements Callback {
//    // $FF: synthetic field
//    final Continuation $continuation;
//
//    public void onFailure(@Nullable Call call, @Nullable Throwable t) {
//       String var3 = "not implemented";
//       boolean var4 = false;
//       throw (Throwable)(new NotImplementedError("An operation is not implemented: " + var3));
//    }
//
//    public void onResponse(@Nullable Call call, @Nullable Response response) {
//       LogKt.log("返回结果");
//       if (response != null) {
//          if (response.isSuccessful()) {
//             ResponseBody var10000 = (ResponseBody)response.body();
//             if (var10000 != null) {
//                InputStream var9 = var10000.byteStream();
//                if (var9 != null) {
//                   byte[] var10 = ByteStreamsKt.readBytes$default(var9, 0, 1, (Object)null);
//                   if (var10 != null) {
//                      byte[] var3 = var10;
//                      Continuation var4 = this.$continuation;
//                      boolean var5 = false;
//                      boolean var6 = false;
//                      int var8 = false;
//                      var4.resume(var3);
//                   }
//                }
//             }
//          } else {
//             this.$continuation.resumeWithException((Throwable)(new HttpException(response.code())));
//          }
//       }
//
//    }
//
//    CoroutinesKt$我要开始加载图片啦不切换线程异步2_1$2$1(Continuation $captured_local_variable$0) {
//       this.$continuation = $captured_local_variable$0;
//    }
// }