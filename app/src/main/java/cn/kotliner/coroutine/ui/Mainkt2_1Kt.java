// package cn.kotliner.coroutine.ui;
//
// import cn.kotliner.coroutine.async.CoroutinesKt;
// import cn.kotliner.coroutine.common.LogKt;
// import cn.kotliner.coroutine.ui.MainWindow;
// import java.awt.event.ActionEvent;
// import kotlin.Metadata;
// import kotlin.Unit;
// import kotlin.coroutines.experimental.Continuation;
// import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
// import kotlin.jvm.functions.Function1;
// import kotlin.jvm.internal.Intrinsics;
// import org.jetbrains.annotations.NotNull;
// import org.jetbrains.annotations.Nullable;
//
// @Metadata(
//    mv = {1, 1, 16},
//    bv = {1, 0, 3},
//    k = 2,
//    d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005¨\u0006\u0006"},
//    d2 = {"main", "", "args", "", "", "([Ljava/lang/String;)V", "app_debug"}
// )
// public final class Mainkt2_1Kt {
//    public static final void main(@NotNull String[] args) {
//       Intrinsics.checkParameterIsNotNull(args, "args");
//       final MainWindow frame = new MainWindow();
//       frame.setTitle("Coroutine@Bennyhuo");
//       frame.setSize(200, 150);
//       frame.setResizable(true);
//       frame.setDefaultCloseOperation(3);
//       frame.init();
//       frame.setVisible(true);
//       frame.onButtonClick((Function1)(new Function1() {
//          // $FF: synthetic method
//          // $FF: bridge method
//          public Object invoke(Object var1) {
//             this.invoke((ActionEvent)var1);
//             return Unit.INSTANCE;
//          }
//
//          public final void invoke(@NotNull ActionEvent it) {
//             Intrinsics.checkParameterIsNotNull(it, "it");
//             LogKt.log("协程之前");
//             CoroutinesKt.我要开始协程啦BaseContinuation((Function1)(new Function1((Continuation)null) {
//                @Nullable
// //看这里注释：block.startCoroutine-》createCoroutineUnchecked(completion).resume(Unit)，doResume不止一次调用
//                public final Object doResume(@Nullable Object data, @Nullable Throwable throwable) {
//                   Exception var10000;
//                   label43: {
//                      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//                      boolean var10001;
//                      Object var9;
//                      switch(super.label) {
//                      case 0:
//                         if (throwable != null) {
//                            throw throwable;
//                         }
//
//                         LogKt.log("协程开始");
//
//                         try {
//                            super.label = 1;//这里把状态置为1，下次进来就不重复走了
//                            var9 = CoroutinesKt.我要开始加载图片啦不切换线程异步2_1("http://www.imooc.com/static/img/index/logo.png?t=1.1", this);
//                         } catch (Exception var6) {
//                            var10000 = var6;
//                            var10001 = false;
//                            break label43;
//                         }
//
//                         if (var9 == var4) {
//                            return var4;
//                         }
//                         break;
//                      case 1:
//                         try {
//                            if (throwable != null) {
//                               throw throwable;
//                            }
//
//                            var9 = data;
//                            break;
//                         } catch (Exception var7) {
//                            var10000 = var7;
//                            var10001 = false;
//                            break label43;
//                         }
//                      default:
//                         throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//                      }
//
//                      try {
//                         byte[] imageData = (byte[])var9;
//                         LogKt.log("拿到图片");
//                         frame.setLogo(imageData);
//                         return Unit.INSTANCE;
//                      } catch (Exception var5) {
//                         var10000 = var5;
//                         var10001 = false;
//                      }
//                   }
//
//                   Exception e = var10000;
//                   e.printStackTrace();
//                   return Unit.INSTANCE;
//                }
//
//                @NotNull
//                public final Continuation create(@NotNull Continuation completion) {
//                   Intrinsics.checkParameterIsNotNull(completion, "completion");
//                   Function1 var2 = new <anonymous constructor>(completion);
//                   return var2;
//                }
//                 //第一次调用
//                public final Object invoke(Object var1) {
//                   return ((<undefinedtype>)this.create((Continuation)var1)).doResume(Unit.INSTANCE, (Throwable)null);
//                }
//             }));
//             LogKt.log("协程之后");
//          }
//       }));
//    }
// }


// CoroutineImpl,从这里可以知道，传进去的 Continuation是最后调用的，等到doResume(null,exception)返回的不是COROUTINE_SUSPENDED
/* override fun resumeWithException(exception:Throwable){
         processBareContinuationResume(completion!!){
         doResume(null,exception)
         }
         }
internal inline fun processBareContinuationResume(completion:Continuation<*>,block:()->Any?){
        try{
        val result=block()
        if(result!==COROUTINE_SUSPENDED){
@Suppress("UNCHECKED_CAST")
            (completion as Continuation<Any?>).resume(result)
        }
        }catch(t:Throwable){
        completion.resumeWithException(t)
        }
        }*/
