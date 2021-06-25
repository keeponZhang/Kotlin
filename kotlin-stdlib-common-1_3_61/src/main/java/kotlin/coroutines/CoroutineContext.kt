/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.coroutines

/**
 * Persistent context for the coroutine. It is an indexed set of [Element] instances.
 * An indexed set is a mix between a set and a map.
 * https://blog.csdn.net/c10WTiybQ1Ye3/article/details/114956973
 */
@SinceKotlin("1.3")
public interface CoroutineContext {
    /**
     * 操作符[]重载，可以通过CoroutineContext[Key]这种形式来获取与Key关联的Element
     */
    public operator fun <E : Element> get(key: Key<E>): E?

    /**
     * Accumulates entries of this context starting with [initial] value and applying [operation]
     * 它是一个聚集函数，提供了从left到right遍历CoroutineContext中每一个Element的能力，并对每一个Element做operation操作
     */
    public fun <R> fold(initial: R, operation: (R, Element) -> R): R

    /**
     * 注释:只有EmptyCoroutineContext覆写了该方法
     * 操作符+重载，可以CoroutineContext + CoroutineContext这种形式把两个CoroutineContext合并成一个;element就是element
     * (本身），combine的就是右侧的elementelement就是element(本身），combine的就是右侧的element；首次调用acc就是init传的this
     * 1+2+3,第二次2+3的时候就变成了，前面1+2的返回值就变成了init，就是acc
     */
    public operator fun plus(context: CoroutineContext): CoroutineContext =
        if (context === EmptyCoroutineContext) this else // fast path -- avoid lambda creation
            context.fold(this) { acc, element ->
                val removed = acc.minusKey(element.key)
                if (removed === EmptyCoroutineContext) element else {
                    // make sure interceptor is always last in the context (and thus is fast to get when present)
                    val interceptor = removed[ContinuationInterceptor]
                    if (interceptor == null) CombinedContext(removed, element) else {
                        val left = removed.minusKey(ContinuationInterceptor)
                        if (left === EmptyCoroutineContext) CombinedContext(element, interceptor) else
                            CombinedContext(CombinedContext(left, element), interceptor)
                    }
                }
            }

    /**
     * Returns a context containing elements from this context, but without an element with
     * the specified [key].
     */
    public fun minusKey(key: Key<*>): CoroutineContext

    /**
     * Key for the elements of [CoroutineContext]. [E] is a type of element with this key.
     * Key定义，空实现，仅仅做一个标识
     */
    public interface Key<E : Element>

    /**
     * An element of the [CoroutineContext]. An element of the coroutine context is a singleton context by itself.
     * Element定义，每个Element都是一个CoroutineContext
     */
    public interface Element : CoroutineContext {
        /**
         * A key of this coroutine context element.
         * 每个Element都有一个Key实例
         */
        public val key: Key<*>

        public override operator fun <E : Element> get(key: Key<E>): E? =
            @Suppress("UNCHECKED_CAST")
            if (this.key == key) this as E else null

        public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
            operation(initial, this)

        public override fun minusKey(key: Key<*>): CoroutineContext =
            if (this.key == key) EmptyCoroutineContext else this
    }
}
