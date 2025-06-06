//package com.example.studycoroutine.chapter.four.jts;
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
///* compiled from: CoroutineRunFour.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"��\n\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010��\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;"})
//@DebugMetadata(f = "CoroutineRunFour.kt", l = {34, 36, 38}, i = {1, 2, 2}, s = {"L$0", "L$0", "L$1"}, n = {"one", "one", "two"}, m = "invokeSuspend", c = "com.example.studycoroutine.chapter.four.CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1")
///* loaded from: CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1.class */
//final class CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
//    Object L$0;
//    Object L$1;
//    int label;
//
//    /* JADX INFO: Access modifiers changed from: package-private */
//    public CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1(Continuation continuation) {
//        super(1, continuation);
//    }
//
//    @NotNull
//    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "completion");
//        return new CoroutineRunFourKt$testFunGetContinuation$mystartSuspend$1(continuation);
//    }
//
//    public final Object invoke(Object obj) {
//        return create((Continuation) obj).invokeSuspend(Unit.INSTANCE);
//    }
//
//    /* JADX WARN: Removed duplicated region for block: B:11:0x005b  */
//    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
//    @Nullable
//    /*
//        Code decompiled incorrectly, please refer to instructions dump.
//    */
//    public final Object invokeSuspend(@NotNull Object $result) {
//        String two;
//        String one;
//        Object obj;
//        Object obj2;
//        Object obj3;
//        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//        switch (this.label) {
//            case 0:
//                ResultKt.throwOnFailure($result);
//                this.label = 1;
//                obj3 = CoroutineRunFourKt.commonSuspendFun(this);
//                if (obj3 == coroutine_suspended) {
//                    return coroutine_suspended;
//                }
//                one = (String) obj3;
//                this.L$0 = one;
//                this.label = 2;
//                obj2 = CoroutineRunFourKt.commonSuspendFun2(this);
//                if (obj2 == coroutine_suspended) {
//                    return coroutine_suspended;
//                }
//                two = (String) obj2;
//                this.L$0 = one;
//                this.L$1 = two;
//                this.label = 3;
//                obj = CoroutineRunFourKt.commonSuspendFun3(this);
//                if (obj == coroutine_suspended) {
//                    return coroutine_suspended;
//                }
//                String three = (String) obj;
//                return one + two + three;
//            case 1:
//                ResultKt.throwOnFailure($result);
//                obj3 = $result;
//                one = (String) obj3;
//                this.L$0 = one;
//                this.label = 2;
//                obj2 = CoroutineRunFourKt.commonSuspendFun2(this);
//                if (obj2 == coroutine_suspended) {
//                }
//                two = (String) obj2;
//                this.L$0 = one;
//                this.L$1 = two;
//                this.label = 3;
//                obj = CoroutineRunFourKt.commonSuspendFun3(this);
//                if (obj == coroutine_suspended) {
//                }
//                String three2 = (String) obj;
//                return one + two + three2;
//            case 2:
//                one = (String) this.L$0;
//                ResultKt.throwOnFailure($result);
//                obj2 = $result;
//                two = (String) obj2;
//                this.L$0 = one;
//                this.L$1 = two;
//                this.label = 3;
//                obj = CoroutineRunFourKt.commonSuspendFun3(this);
//                if (obj == coroutine_suspended) {
//                }
//                String three22 = (String) obj;
//                return one + two + three22;
//            case 3:
//                two = (String) this.L$1;
//                one = (String) this.L$0;
//                ResultKt.throwOnFailure($result);
//                obj = $result;
//                String three222 = (String) obj;
//                return one + two + three222;
//            default:
//                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//        }
//    }
//}