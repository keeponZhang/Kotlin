//package com.example.studycoroutine.chapter.four.jts;
//
//import com.example.studycoroutine.chapter.two.MyCoroutine;
//import kotlin.Metadata;
//import kotlin.Result;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.ContinuationKt;
//import kotlin.jvm.functions.Function1;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///* compiled from: CoroutineRunFour.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"��\u0012\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0011\u0010��\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0003\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0011\u0010\u0004\u001a\u00020\u0001H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0002\u001a\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0006\u0010\u0007\u001a\u00020\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"commonSuspendFun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonSuspendFun2", "commonSuspendFun3", "main", "", "testFunGetContinuation", "coroutine_debug"})
///* loaded from: CoroutineRunFourKt.class */
//public final class CoroutineRunFourKt {
//    @Nullable
//    public static final Object commonSuspendFun(@NotNull Continuation<? super String> continuation) {
//        return "[hello world] ";
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
//        testFunGetContinuation();
//    }
//
//    public static final void testFunGetContinuation() {
//        Function1 mystartSuspend = new CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1(null);
//        Continuation createCoroutine = ContinuationKt.createCoroutine(mystartSuspend, new MyCoroutine());
//        Unit unit = Unit.INSTANCE;
//        Result.Companion companion = Result.Companion;
//        createCoroutine.resumeWith(Result.constructor-impl(unit));
//    }
//}