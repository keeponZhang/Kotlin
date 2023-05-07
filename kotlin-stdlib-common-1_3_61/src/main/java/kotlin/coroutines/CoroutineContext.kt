/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.coroutines

/**
 * Persistent context for the coroutine. It is an indexed set of [Element] instances.
 * An indexed set is a mix between a set and a map.
 * Every element in this set has a unique [Key].
 */
@SinceKotlin("1.3")
public interface CoroutineContext {
    /**
     * Returns the element with the given [key] from this context or `null`.
     */
    public operator fun <E : Element> get(key: Key<E>): E?

    /**
     * Accumulates entries of this context starting with [initial] value and applying [operation]
     * from left to right to current accumulator value and each element of this context.
     */
    public fun <R> fold(initial: R, operation: (R, Element) -> R): R
    //注释：右边被加的那个调用fold方法，fold的初始值传入的是this，elementV1+elementV2，acc是elementV1，element是elementV2   https://blog.csdn.net/xufei5789651/article/details/122902980
    // 左边那个调用minusKey方法，并且传入的是右边被加的Key，这里分2个情况，1如果左边的是element，如果左边的Key与右边的Key相等，返回EmptyCoroutineContext，否则相当于没减成功，返回当前element
    //注释1:我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element    注释2:从左边CoroutineContext中删除右边的这个element
    //注释3:如果removed为空，说明左边CoroutineContext删除了和element相同的元素后为空，那么返回右边的element即可   注释4:如果removed不为空，说明左边CoroutineContext删除了和element相同的元素后还有其他元素，那么构造一个新的CombinedContext返回
    //注释5:左边的元素没有拦截器，直接闯将一个CombinedContext，原来的元素为left，被加的为element  注释6-1：左边只有一个ContinuationInterceptor，创建CombinedContext，interceptor放在最右边  注释6-2：
    public operator fun plus(context: CoroutineContext): CoroutineContext =
        if (context === EmptyCoroutineContext) this else // fast path -- avoid lambda creation
            context.fold(this) { acc, element ->   // 注释1
                val removed = acc.minusKey(element.key)  // 注释2
                if (removed === EmptyCoroutineContext) element else {  //注释3
                    // make sure interceptor is always last in the context (and thus is fast to get when present)
                    val interceptor = removed[ContinuationInterceptor]  //注释4
                    if (interceptor == null) CombinedContext(removed, element) else { //注释5
                        val left = removed.minusKey(ContinuationInterceptor)
                        if (left === EmptyCoroutineContext) CombinedContext(element, interceptor) else  //注释6-1
                            CombinedContext(CombinedContext(left, element), interceptor)   //注释6-2
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
     */
    public interface Key<E : Element>

    /**
     * An element of the [CoroutineContext]. An element of the coroutine context is a singleton context by itself.
     */
    public interface Element : CoroutineContext {
        /**
         * A key of this coroutine context element.
         */
        public val key: Key<*>

        public override operator fun <E : Element> get(key: Key<E>): E? =
            @Suppress("UNCHECKED_CAST")
            if (this.key == key) this as E else null

        public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
            operation(initial, this)
        //if (this.key == key) EmptyCoroutineContext 注意这里
        public override fun minusKey(key: Key<*>): CoroutineContext =  //如果Key与当前element的Key相等，返回EmptyCoroutineContext，否则相当于没减成功，返回当前element
            if (this.key == key) EmptyCoroutineContext else this
    }
}
internal class CombinedContextDoc(val left: kotlin.coroutines.experimental.CoroutineContext, val element: kotlin.coroutines.experimental.CoroutineContext.Element) :
    kotlin.coroutines.experimental.CoroutineContext {
    override fun <E : kotlin.coroutines.experimental.CoroutineContext.Element> get(key: kotlin.coroutines.experimental.CoroutineContext.Key<E>): E? {
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

    public override fun <R> fold(initial: R, operation: (R, kotlin.coroutines.experimental.CoroutineContext.Element) -> R): R =
        operation(left.fold(initial, operation), element)
    // CombinedContext minusKey 方法：删除链表中符合条件的节点，分三种情况。
    public override fun minusKey(key: kotlin.coroutines.experimental.CoroutineContext.Key<*>): kotlin.coroutines.experimental.CoroutineContext {
        element[key]?.let { return left }
        val newLeft = left.minusKey(key)
        return when {
            newLeft === left -> this
            newLeft === kotlin.coroutines.experimental.EmptyCoroutineContext -> element
            else -> kotlin.coroutines.experimental.CombinedContext(newLeft, element)
        }
    }
}
