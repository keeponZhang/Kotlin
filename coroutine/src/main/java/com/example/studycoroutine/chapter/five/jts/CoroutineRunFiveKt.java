package com.example.studycoroutine.chapter.five.jts;

import com.bennyhuo.kotlin.coroutines.utils.LogKt;
import com.example.studycoroutine.chapter.two.MyCoroutine;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineRunFive.kt */
@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"��\u0010\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0006\u0010��\u001a\u00020\u0001\u001a\u0011\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0003H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0004\u001a\u0006\u0010\u0006\u001a\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"main", "", "mySafeSuspendOne", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mySuspendOne", "testFiveOne", "coroutine_debug"})
/* loaded from: CoroutineRunFiveKt.class */
public final class CoroutineRunFiveKt {
    public static final void main() {
        testFiveOne();
    }

    @Nullable
    public static final Object mySuspendOne(@NotNull final Continuation<? super String> continuation) {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Function0<Unit>() { // from class: com.example.studycoroutine.chapter.five.CoroutineRunFiveKt$mySuspendOne$2$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1invoke() {
                TimeUnit.SECONDS.sleep(1L);
                LogKt.log(new Object[]{"mySuspendOne 我将调用Continuation返回一个数据"});
                Continuation continuation2 = continuation;
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl("hello world"));
            }
        }, 31, (Object) null);
        LogKt.log(new Object[]{"mySuspendOne 函数返回"});
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutine_suspended == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return coroutine_suspended;
    }

    @Nullable
    public static final Object mySafeSuspendOne(@NotNull Continuation<? super String> continuation) {
        Continuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final Continuation continuation2 = safeContinuation;
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new Function0<Unit>() { // from class: com.example.studycoroutine.chapter.five.CoroutineRunFiveKt$mySafeSuspendOne$2$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m0invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m0invoke() {
                TimeUnit.SECONDS.sleep(1L);
                LogKt.log(new Object[]{"mySafeSuspendOne 我将调用Continuation返回一个数据"});
                Continuation continuation3 = continuation2;
                Result.Companion companion = Result.Companion;
                continuation3.resumeWith(Result.constructor-impl("hello world "));
            }
        }, 31, (Object) null);
        LogKt.log(new Object[]{"mySuspendOne 函数返回"});
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final void testFiveOne() {
        Continuation myCoroutine = new MyCoroutine();
        Function1 mystartSuspend = new CoroutineRunFiveKt$testFiveOne$mystartSuspend$1(null);
        ContinuationKt.startCoroutine(mystartSuspend, myCoroutine);
        LogKt.log(new Object[]{"启动协程，由于两个挂起函数延迟返回结果所以这句话会先打出来"});
    }
}