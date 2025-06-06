//package com.example.studycoroutine.chapter.five.jts;
//
//import kotlin.Metadata;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.intrinsics.IntrinsicsKt;
//import kotlin.coroutines.jvm.internal.DebugMetadata;
//import kotlin.coroutines.jvm.internal.SuspendLambda;
//import kotlin.jvm.functions.Function1;
//import kotlin.jvm.internal.Intrinsics;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///* compiled from: CoroutineRunFive.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"��\n\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010��\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
//@DebugMetadata(f = "CoroutineRunFive.kt", l = {56}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "com.example.studycoroutine.chapter.five.CoroutineRunFiveKt$testFiveOne$mystartSuspend$1")
///* loaded from: CoroutineRunFiveKt$testFiveOne$mystartSuspend$1.class */
//final class CoroutineRunFiveKt$testFiveOne$mystartSuspend$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
//    int label;
//
//    /* JADX INFO: Access modifiers changed from: package-private */
//    public CoroutineRunFiveKt$testFiveOne$mystartSuspend$1(Continuation continuation) {
//        super(1, continuation);
//    }
//
//    @NotNull
//    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "completion");
//        return new CoroutineRunFiveKt$testFiveOne$mystartSuspend$1(continuation);
//    }
//
//    public final Object invoke(Object obj) {
//        return create((Continuation) obj).invokeSuspend(Unit.INSTANCE);
//    }
//
//    @Nullable
//    public final Object invokeSuspend(@NotNull Object $result) {
//        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//        switch (this.label) {
//            case 0:
//                ResultKt.throwOnFailure($result);
//                this.label = 1;
//                Object mySuspendOne = CoroutineRunFiveKt.mySuspendOne(this);
//                if (mySuspendOne == coroutine_suspended) {
//                    return coroutine_suspended;
//                }
//                return mySuspendOne;
//            case 1:
//                ResultKt.throwOnFailure($result);
//                return $result;
//            default:
//                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//        }
//    }
//}