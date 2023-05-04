package cn.kotliner.coroutine.async;

import org.jetbrains.annotations.NotNull;

import cn.kotliner.coroutine.basic.BaseContinuation;
import kotlin.Unit;
import kotlin.coroutines.experimental.Continuation;
import kotlin.coroutines.experimental.CoroutineContext;
import kotlin.coroutines.experimental.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/**
 * Time:2023-05-04 下午 11:41
 * Author:
 * Description:
 */
class Coroutines_decompliled {
    /* renamed from: 我要开始协程啦BaseContinuation  reason: contains not printable characters */
    public static final void m0BaseContinuation(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new BaseContinuation());
    }

    /* renamed from: 我要开始协程啦OnlyAsyncContext3_  reason: contains not printable characters */
    public static final void m1OnlyAsyncContext3_(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new ContextContinuation(new AsyncContext()));
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation_4_1$default  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ void m7ContextContextContinuation_4_1$default(CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        m6ContextContextContinuation_4_1((i & 1) != 0 ? (CoroutineContext) EmptyCoroutineContext.INSTANCE : coroutineContext, function1);
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation_4_1  reason: contains not printable characters */
    public static final void m6ContextContextContinuation_4_1(@NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new ContextContinuation(context));
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation4_2$default  reason: contains not printable characters */
    public static /* bridge */ /* synthetic */ void m5ContextContextContinuation4_2$default(CoroutineContext coroutineContext, Function1 function1, int i, Object obj) {
        m4ContextContextContinuation4_2((i & 1) != 0 ? (CoroutineContext) EmptyCoroutineContext.INSTANCE : coroutineContext, function1);
    }

    /* renamed from: 我要开始协程啦自定义Context使用ContextContinuation4_2  reason: contains not printable characters */
    public static final void m4ContextContextContinuation4_2(@NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new ContextContinuation(context.plus(new DownloadContext("http://www.imooc.com/static/img/index/logo.png?t=1.1"))));
    }

    /* renamed from: 我要开始协程啦TwoAsyncContext3_2  reason: contains not printable characters */
    public static final void m2TwoAsyncContext3_2(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new ContextContinuation(new AsyncContext().plus(new AsyncContext3())));
    }

    /* renamed from: 我要开始协程啦TwoAsyncContext3_3  reason: contains not printable characters */
    public static final void m3TwoAsyncContext3_3(@NotNull Function1<? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        kotlin.coroutines.experimental.CoroutinesKt.startCoroutine(block, new ContextContinuation(new AsyncContext3().plus(new AsyncContext())));
    }

    public static final void main(@NotNull String[] args) {
        Intrinsics.checkParameterIsNotNull(args, "args");
    }

}
