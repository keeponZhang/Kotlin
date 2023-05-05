package cn.kotliner.coroutine.async;

import cn.kotliner.coroutine.basic.BaseContinuation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 1, 10}, bv = {1, 0, 2}, k = 2, d1 = {"��,\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010��\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005\u001a,\u0010\u0006\u001a\u00020\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u000b\u001a,\u0010\f\u001a\u00020\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u000b\u001a,\u0010\r\u001a\u00020\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u000b\u001a,\u0010\u000e\u001a\u00020\u00012\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u000b\u001a6\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u0012\u001a6\u0010\u0013\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u001c\u0010\u0007\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bø\u0001��¢\u0006\u0002\u0010\u0012\u0082\u0002\u0004\n\u0002\b\t¨\u0006\u0014"}, d2 = {"main", "", "args", "", "", "([Ljava/lang/String;)V", "我要开始协程啦BaseContinuation", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/experimental/Continuation;", "", "(Lkotlin/jvm/functions/Function1;)V", "我要开始协程啦OnlyAsyncContext3_", "我要开始协程啦TwoAsyncContext3_2", "我要开始协程啦TwoAsyncContext3_3", "我要开始协程啦自定义Context使用ContextContinuation4_2", "context", "Lkotlin/coroutines/experimental/CoroutineContext;", "(Lkotlin/coroutines/experimental/CoroutineContext;Lkotlin/jvm/functions/Function1;)V", "我要开始协程啦自定义Context使用ContextContinuation_4_1", "app_debug"})
/* renamed from: cn.kotliner.coroutine.async.CoroutinesKt */
/* loaded from: CoroutinesKt.class */
public final class Coroutines {
    /* renamed from: 我要开始协程啦BaseContinuation  reason: contains not printable characters */
    public static final void m0BaseContinuation(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new BaseContinuation());
    }

    /* renamed from: 我要开始协程啦OnlyAsyncContext3_  reason: contains not printable characters */
    public static final void m1OnlyAsyncContext3_(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new ContextContinuation(new AsyncContext()));
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation_4_1$default  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ void m3ContextContextContinuation_4_1$default(CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        m2ContextContextContinuation_4_1(coroutineContext, function1);
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation_4_1  reason: contains not printable characters */
    public static final void m2ContextContextContinuation_4_1(@NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new ContextContinuation(context));
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation4_2$default  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ void m5ContextContextContinuation4_2$default(CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        m4ContextContextContinuation4_2(coroutineContext, function1);
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation4_2  reason: contains not printable characters */
    public static final void m4ContextContextContinuation4_2(@NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new ContextContinuation(context.plus(new DownloadContext("http://www.imooc.com/static/img/index/logo.png?t=1.1"))));
    }

    /* renamed from: 我要开始协程啦TwoAsyncContext3_2  reason: contains not printable characters */
    public static final void m6TwoAsyncContext3_2(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new ContextContinuation(new AsyncContext().plus(new AsyncContext3())));
    }

    /* renamed from: 我要开始协程啦TwoAsyncContext3_3  reason: contains not printable characters */
    public static final void m7TwoAsyncContext3_3(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(function1, new ContextContinuation(new AsyncContext3().plus(new AsyncContext())));
    }

    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
    }
}