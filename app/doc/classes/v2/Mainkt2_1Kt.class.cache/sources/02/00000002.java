package cn.kotliner.coroutine.p000ui.mainkt2;

import cn.kotliner.coroutine.async.CoroutinesKt;
import cn.kotliner.coroutine.common.LogKt;
import cn.kotliner.coroutine.ui.MainWindow;
import java.awt.event.ActionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.intrinsics.IntrinsicsKt;
import kotlin.coroutines.experimental.jvm.internal.CoroutineImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Mainkt2_1.kt */
@Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 3, d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/awt/event/ActionEvent;", "invoke"})
/* renamed from: cn.kotliner.coroutine.ui.mainkt2.Mainkt2_1Kt$main$1 */
/* loaded from: Mainkt2_1Kt$main$1.class */
public final class Mainkt2_1Kt$main$1 extends Lambda implements Function1<ActionEvent, Unit> {
    final /* synthetic */ MainWindow $frame;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ActionEvent) obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Mainkt2_1Kt$main$1(MainWindow mainWindow) {
        super(1);
        this.$frame = mainWindow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Mainkt2_1.kt */
    @Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 3, d1 = {"��\n\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010��\u001a\u00020\u0001H\u008a@ø\u0001��¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Lkotlin/coroutines/experimental/Continuation;)Ljava/lang/Object;"})
    /* renamed from: cn.kotliner.coroutine.ui.mainkt2.Mainkt2_1Kt$main$1$1 */
    /* loaded from: Mainkt2_1Kt$main$1$1.class */
    public static final class C00001 extends CoroutineImpl implements Function1<Continuation<? super Unit>, Object> {
        C00001(Continuation continuation) {
            super(1, continuation);
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            return new C00001(continuation);
        }

        @Nullable
        public final Object invoke(@NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            return create(continuation).doResume(Unit.INSTANCE, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        @Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object doResume(@Nullable Object data, @Nullable Throwable throwable) {
            Object obj;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (((CoroutineImpl) this).label) {
                case 0:
                    if (throwable != null) {
                        throw throwable;
                    }
                    LogKt.log("协程开始");
                    Mainkt2_1.test2();
                    ((CoroutineImpl) this).label = 1;
                    if (Mainkt2_1.testsuspend(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ((CoroutineImpl) this).label = 2;
                    obj = Mainkt2_1.getPicSyn("http://www.imooc.com/static/img/index/logo.png?t=1.1", this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    byte[] imageData = (byte[]) obj;
                    LogKt.log("拿到图片");
                    Mainkt2_1Kt$main$1.this.$frame.setLogo(imageData);
                    return Unit.INSTANCE;
                case 1:
                    if (throwable != null) {
                        throw throwable;
                    }
                    ((CoroutineImpl) this).label = 2;
                    obj = Mainkt2_1.getPicSyn("http://www.imooc.com/static/img/index/logo.png?t=1.1", this);
                    if (obj == coroutine_suspended) {
                    }
                    byte[] imageData2 = (byte[]) obj;
                    LogKt.log("拿到图片");
                    Mainkt2_1Kt$main$1.this.$frame.setLogo(imageData2);
                    return Unit.INSTANCE;
                case 2:
                    if (throwable != null) {
                        throw throwable;
                    }
                    obj = data;
                    byte[] imageData22 = (byte[]) obj;
                    LogKt.log("拿到图片");
                    Mainkt2_1Kt$main$1.this.$frame.setLogo(imageData22);
                    return Unit.INSTANCE;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public final void invoke(@NotNull ActionEvent it) {
        Intrinsics.checkParameterIsNotNull(it, "it");
        LogKt.log("协程之前");
        CoroutinesKt.我要开始协程啦BaseContinuation(new C00001(null));
        LogKt.log("协程之后");
    }
}