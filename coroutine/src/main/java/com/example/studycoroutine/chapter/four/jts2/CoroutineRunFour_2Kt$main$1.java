//package com.example.studycoroutine.chapter.four.jts2;
//
//import kotlin.Metadata;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.intrinsics.IntrinsicsKt;
//import kotlin.coroutines.jvm.internal.DebugMetadata;
//import kotlin.coroutines.jvm.internal.SuspendLambda;
//import kotlin.jvm.functions.Function2;
//import kotlin.jvm.internal.Intrinsics;
//import kotlinx.coroutines.CoroutineScope;
//import kotlinx.coroutines.DelayKt;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///* compiled from: CoroutineRunFour_2.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010��\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
//@DebugMetadata(f = "CoroutineRunFour_2.kt", l = {32}, i = {0}, s = {"L$0"}, n = {"$this$runBlocking"}, m = "invokeSuspend", c = "com.example.studycoroutine.chapter.four2.CoroutineRunFour_2Kt$main$1")
///* loaded from: CoroutineRunFour_2Kt$main$1.class */
//final class CoroutineRunFour_2Kt$main$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
//    private CoroutineScope p$;
//    Object L$0;
//    int label;
//
//    /* JADX INFO: Access modifiers changed from: package-private */
//    public CoroutineRunFour_2Kt$main$1(Continuation continuation) {
//        super(2, continuation);
//    }
//
//    @NotNull
//    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "completion");
//        CoroutineRunFour_2Kt$main$1 coroutineRunFour_2Kt$main$1 = new CoroutineRunFour_2Kt$main$1(continuation);
//        CoroutineScope coroutineScope = (CoroutineScope) value;
//        coroutineRunFour_2Kt$main$1.p$ = (CoroutineScope) value;
//        return coroutineRunFour_2Kt$main$1;
//    }
//
//    public final Object invoke(Object obj, Object obj2) {
//        return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
//    }
//
//    @Nullable
//    public final Object invokeSuspend(@NotNull Object $result) {
//        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
//        switch (this.label) {
//            case 0:
//                ResultKt.throwOnFailure($result);
//                CoroutineScope $this$runBlocking = this.p$;
//                CoroutineRunFour_2Kt.testFunGetContinuation();
//                this.L$0 = $this$runBlocking;
//                this.label = 1;
//                if (DelayKt.delay(3000L, this) == coroutine_suspended) {
//                    return coroutine_suspended;
//                }
//                break;
//            case 1:
//                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
//                ResultKt.throwOnFailure($result);
//                break;
//            default:
//                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//        }
//        return Unit.INSTANCE;
//    }
//}