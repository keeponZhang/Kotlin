//package com.example.studycoroutine.chapter.two.jts;
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
///* compiled from: CoroutineRun2.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 2, d1 = {"��\u0010\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0006\u0010��\u001a\u00020\u0001\u001a\u0011\u0010\u0002\u001a\u00020\u0003H\u0086@ø\u0001��¢\u0006\u0002\u0010\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0001\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"main", "", "mySuspendFun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testOne", "coroutine_debug"})
///* loaded from: CoroutineRun2Kt.class */
//public final class CoroutineRun2Kt {
//    @Nullable
//    public static final Object mySuspendFun(@NotNull Continuation<? super String> continuation) {
//        return "hello";
//    }
//
//    public static final void main() {
//        testOne();
//    }
//
//    public static final void testOne() {
//        Function1 myCoroutineFun = new CoroutineRun2Kt$testOne$myCoroutineFun$1(null);
//        Continuation createCoroutine = ContinuationKt.createCoroutine(myCoroutineFun, new MyCoroutine());
//        Unit unit = Unit.INSTANCE;
//        Result.Companion companion = Result.Companion;
//        createCoroutine.resumeWith(Result.constructor-impl(unit));
//    }
//}