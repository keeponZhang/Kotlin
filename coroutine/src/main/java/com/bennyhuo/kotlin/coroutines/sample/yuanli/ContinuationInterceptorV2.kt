/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package com.bennyhuo.kotlin.coroutines.sample.yuanli

import kotlin.coroutines.Continuation

/**
 * Marks coroutine context element that intercepts coroutine continuations.
 * The coroutines framework uses [ContinuationInterceptorV2.Key] to retrieve the interceptor and
 * intercepts all coroutine continuations with [interceptContinuation] invocations.
 */
@SinceKotlin("1.3")
public interface ContinuationInterceptorV2 : ElementV2 {
    /**
     * The key that defines *the* context interceptor.
     */
    companion object Key : CoroutineContextV2.KeyV2<ContinuationInterceptorV2>

    /**
     * Returns continuation that wraps the original [continuation], thus intercepting all resumptions.
     * This function is invoked by coroutines framework when needed and the resulting continuations are
     * cached internally per each instance of the original [continuation].
     *
     * This function may simply return original [continuation] if it does not want to intercept this particular continuation.
     *
     * When the original [continuation] completes, coroutine framework invokes [releaseInterceptedContinuation]
     * with the resulting continuation if it was intercepted, that is if `interceptContinuation` had previously
     * returned a different continuation instance.
     */
    public fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T>

    /**
     * Invoked for the continuation instance returned by [interceptContinuation] when the original
     * continuation completes and will not be used anymore. This function is invoked only if [interceptContinuation]
     * had returned a different continuation instance from the one it was invoked with.
     *
     * Default implementation does nothing.
     *
     * @param continuation Continuation instance returned by this interceptor's [interceptContinuation] invocation.
     */
    public fun releaseInterceptedContinuation(continuation: Continuation<*>) {
        /* do nothing by default */
    }

    // Performance optimization for a singleton Key
    public override operator fun <E : ElementV2> get(key: CoroutineContextV2.KeyV2<E>): E? =
            @Suppress("UNCHECKED_CAST")
            if (key === Key) this as E else null

    // Performance optimization to a singleton Key
    public override fun minusKey(
            key: CoroutineContextV2.KeyV2<*>, elementV2: ElementV2
    ): CoroutineContextV2 =
            if (key === Key) EmptyCoroutineContextV2 else this
}
