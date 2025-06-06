//package com.example.studycoroutine.chapter.four.jts2;
//
//import com.example.studycoroutine.chapter.two.MyCoroutine;
//import kotlin.Metadata;
//import kotlin.Result;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.ContinuationKt;
//import kotlin.coroutines.CoroutineContext;
//import kotlin.coroutines.intrinsics.IntrinsicsKt;
//import kotlin.jvm.functions.Function1;
//import kotlinx.coroutines.BuildersKt;
//import kotlinx.coroutines.DelayKt;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///* compiled from: CoroutineRunFour_2.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"��\u0012\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010��\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"commonSuspendFun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonSuspendFun2", "commonSuspendFun3", "main", "", "testFunGetContinuation", "coroutine_debug"})
///* loaded from: CoroutineRunFour_2Kt.class */
//public final class CoroutineRunFour_2Kt {
//    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
//    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
//    /* JADX WARN: Removed duplicated region for block: B:17:0x0070  */
//    @Nullable
//    /*
//        Code decompiled incorrectly, please refer to instructions dump.
//    */
//    public static final Object commonSuspendFun(@NotNull Continuation<? super String> continuation) {
//        CoroutineRunFour_2Kt$commonSuspendFun$1 coroutineRunFour_2Kt$commonSuspendFun$1;
//        if (continuation instanceof CoroutineRunFour_2Kt$commonSuspendFun$1) {
//            coroutineRunFour_2Kt$commonSuspendFun$1 = (CoroutineRunFour_2Kt$commonSuspendFun$1) continuation;
//            if ((coroutineRunFour_2Kt$commonSuspendFun$1.label & Integer.MIN_VALUE) != 0) {
//                coroutineRunFour_2Kt$commonSuspendFun$1.label -= Integer.MIN_VALUE;
//                Object $result = coroutineRunFour_2Kt$commonSuspendFun$1.result;
//                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//                switch (coroutineRunFour_2Kt$commonSuspendFun$1.label) {
//                    case 0:
//                        ResultKt.throwOnFailure($result);
//                        coroutineRunFour_2Kt$commonSuspendFun$1.label = 1;
//                        return DelayKt.delay(1000L, coroutineRunFour_2Kt$commonSuspendFun$1) == coroutine_suspended ? coroutine_suspended : "[hello world] ";
//                    case 1:
//                        ResultKt.throwOnFailure($result);
//                        return "[hello world] ";
//                    default:
//                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//                }
//            }
//        }
//        coroutineRunFour_2Kt$commonSuspendFun$1 = new CoroutineRunFour_2Kt$commonSuspendFun$1(continuation);
//        Object $result2 = coroutineRunFour_2Kt$commonSuspendFun$1.result;
//        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//        switch (coroutineRunFour_2Kt$commonSuspendFun$1.label) {
//        }
//    }
//
//    @Nullable
//    public static final Object commonSuspendFun2(@NotNull Continuation<? super String> continuation) {
//        return "[hello world 2]  ";
//    }
//
//    @Nullable
//    public static final Object commonSuspendFun3(@NotNull Continuation<? super String> continuation) {
//        return "[hello world 3]";
//    }
//
//    public static final void main() {
//        BuildersKt.runBlocking$default((CoroutineContext) null, new CoroutineRunFour_2Kt$main$1(null), 1, (Object) null);
//    }
//
//    public static final void testFunGetContinuation() {
//        Function1 mystartSuspend = new CoroutineRunFour_2Kt$testFunGetContinuation$mystartSuspend$1(null);
//        Continuation createCoroutine = ContinuationKt.createCoroutine(mystartSuspend, new MyCoroutine());
//        Unit unit = Unit.INSTANCE;
//        Result.Companion companion = Result.Companion;
//        createCoroutine.resumeWith(Result.constructor-impl(unit));
//    }
//}