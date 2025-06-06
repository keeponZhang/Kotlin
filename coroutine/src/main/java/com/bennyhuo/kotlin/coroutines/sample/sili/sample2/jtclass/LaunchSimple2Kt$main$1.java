//package com.bennyhuo.kotlin.coroutines.sample.sili.sample2.jtclass;
//
//import com.bennyhuo.kotlin.coroutines.scope.CoroutineScope;
//import kotlin.Metadata;
//import kotlin.ResultKt;
//import kotlin.Unit;
//import kotlin.coroutines.Continuation;
//import kotlin.coroutines.intrinsics.IntrinsicsKt;
//import kotlin.coroutines.jvm.internal.DebugMetadata;
//import kotlin.coroutines.jvm.internal.SuspendLambda;
//import kotlin.jvm.functions.Function2;
//import kotlin.jvm.internal.Intrinsics;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
///* compiled from: LaunchSimple2.kt */
//@Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 3, d1 = {"��\u000e\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010��\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lcom/bennyhuo/kotlin/coroutines/scope/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
//@DebugMetadata(f = "LaunchSimple2.kt", l = {}, i = {}, s = {}, n = {}, m = "invokeSuspend", c = "com.bennyhuo.kotlin.coroutines.sample.sili.sample2.jtclass.LaunchSimple2Kt$main$1")
///* loaded from: LaunchSimple2Kt$main$1.class */
//final class LaunchSimple2Kt$main$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
//    private CoroutineScope p$;
//    int label;
//
//    /* JADX INFO: Access modifiers changed from: package-private */
//    public LaunchSimple2Kt$main$1(Continuation continuation) {
//        super(2, continuation);
//    }
//
//    @NotNull
//    public final Continuation<Unit> create(@Nullable Object value, @NotNull Continuation<?> continuation) {
//        Intrinsics.checkParameterIsNotNull(continuation, "completion");
//        LaunchSimple2Kt$main$1 launchSimple2Kt$main$1 = new LaunchSimple2Kt$main$1(continuation);
//        CoroutineScope coroutineScope = (CoroutineScope) value;
//        launchSimple2Kt$main$1.p$ = (CoroutineScope) value;
//        return launchSimple2Kt$main$1;
//    }
//
//    public final Object invoke(Object obj, Object obj2) {
//        return create(obj, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
//    }
//
//    @Nullable
//    public final Object invokeSuspend(@NotNull Object $result) {
//        IntrinsicsKt.getCOROUTINE_SUSPENDED();
//        switch (this.label) {
//            case 0:
//                ResultKt.throwOnFailure($result);
//                CoroutineScope coroutineScope = this.p$;
//                System.out.println((Object) "MainActivity.onCreate");
//                return Unit.INSTANCE;
//            default:
//                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
//        }
//    }
//}


///Users/keeponzhang/Downloads/study/codeWorkSpace/mycode/keeponGitgub/Kotlin1_3/coroutine/build/tmp/kotlin-classes/debug/com/bennyhuo/kotlin/coroutines/sample/sili/sample2/LaunchSimple2Kt$main$1.class