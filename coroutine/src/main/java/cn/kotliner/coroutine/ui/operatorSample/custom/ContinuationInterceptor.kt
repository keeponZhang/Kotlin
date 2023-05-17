/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package cn.kotliner.coroutine.ui.operatorSample.custom

/**
 * Marks coroutine context element that intercepts coroutine continuations.
 * The coroutines framework uses [ContinuationInterceptor.Key] to retrieve the interceptor and
 * intercepts all coroutine continuations with [interceptContinuation] invocations.
 */
@SinceKotlin("1.3")
public interface ContinuationInterceptor : CoroutineContext.Element {
    override var name: String

    /**
     * The key that defines *the* context interceptor.
     */
    companion object Key : CoroutineContext.Key<ContinuationInterceptor>


    // Performance optimization for a singleton Key
    public override operator fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? =
        @Suppress("UNCHECKED_CAST")
        if (key === Key) this as E else null

    // Performance optimization to a singleton Key
    public override fun minusKey(key: CoroutineContext.Key<*>): CoroutineContext =
        if (key === Key) EmptyCoroutineContext else this
}
