/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.coroutines.experimental

/**
 * Persistent context for the coroutine. It is an indexed set of [Element] instances.
 * https://mp.weixin.qq.com/s/qCCOHPIRxTf6apaTV_Lfmw
 * Every element in this set has a unique [Key]. Keys are compared _by reference_.
 */
@SinceKotlin("1.1")
public interface CoroutineContext {
    /**
     * Returns the element with the given [key] from this context or `null`.
     * Keys are compared _by reference_, that is to get an element from the context the reference to its actual key
     * object must be presented to this function.
     */
    public operator fun <E : Element> get(key: Key<E>): E?

    /**
     * Accumulates entries of this context starting with [initial] value and applying [operation]
     * from left to right to current accumulator value and each element of this context.
     */
    public fun <R> fold(initial: R, operation: (R, Element) -> R): R

    /**
     * Returns a context containing elements from this context and elements from  other [context].
     * The elements from this context with the same key as in the other one are dropped.
     */
    public operator fun plus(context: CoroutineContext): CoroutineContext =
        if (context === EmptyCoroutineContext) this else {// fast path -- avoid lambda creation
            context.fold(this) { acc, element ->
                val removed = acc.minusKey(element.key)
                if (removed === EmptyCoroutineContext) element else {
                    // make sure interceptor is always last in the context (and thus is fast to get when present)
                    val interceptor = removed[ContinuationInterceptor]
                    val combinedContext =
                        if (interceptor == null) CombinedContext(removed, element) else {
                            val left = removed.minusKey(ContinuationInterceptor)
                            if (left === EmptyCoroutineContext) CombinedContext(
                                element,
                                interceptor
                            ) else
                                CombinedContext(CombinedContext(left, element), interceptor)
                        }
                    combinedContext
                }
            }
        }

    /**
     * Returns a context containing elements from this context, but without an element with
     * the specified [key]. Keys are compared _by reference_, that is to remove an element from the context
     * the reference to its actual key object must be presented to this function.
     */
    public fun minusKey(key: Key<*>): CoroutineContext

    /**
     * An element of the [CoroutineContext]. An element of the coroutine context is a singleton context by itself.注释:Element有一个长远变量key，类型是Key
     */
    public interface Element : CoroutineContext {
        /**
         * A key of this coroutine context element.
         */
        public val key: Key<*>

        @Suppress("UNCHECKED_CAST")
        public override operator fun <E : Element> get(key: Key<E>): E? =
            if (this.key === key) this as E else null

        public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
            operation(initial, this)

        public override fun minusKey(key: Key<*>): CoroutineContext = //如果 Key与当前 element的Key相等，返回EmptyCoroutineContext，否则相当于没减成功，返回当前element
            if (this.key === key) EmptyCoroutineContext else this
    }

    /**
     * Key for the elements of [CoroutineContext]. [E] is a type of element with this key.
     * Keys in the context are compared _by reference_.
     */
    public interface Key<E : Element>
}

internal class CombinedContextDoc(val left: CoroutineContext, val element: CoroutineContext.Element) : CoroutineContext {
    override fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? {
        var cur = this
        while (true) {
            cur.element[key]?.let { return it }
            val next = cur.left
            if (next is CombinedContextDoc) {
                cur = next
            } else {
                return next[key]
            }
        }
    }

    public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R =
        operation(left.fold(initial, operation), element)

    public override fun minusKey(key: CoroutineContext.Key<*>): CoroutineContext {
        element[key]?.let { return left }
        val newLeft = left.minusKey(key)
        return when {
            newLeft === left -> this
            newLeft === EmptyCoroutineContext -> element
            else -> CombinedContext(newLeft, element)
        }
    }
}

