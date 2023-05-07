/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin.coroutines.experimental

import kotlin.coroutines.experimental.CoroutineContext.*

/**
 * Base class for [CoroutineContext.Element] implementations.
 */
@SinceKotlin("1.1")
public abstract class AbstractCoroutineContextElement(public override val key: Key<*>) : Element

/**
 * An empty coroutine context.
 */
@SinceKotlin("1.1")
public object EmptyCoroutineContext : CoroutineContext {
    public override fun <E : Element> get(key: Key<E>): E? = null
    public override fun <R> fold(initial: R, operation: (R, Element) -> R): R = initial
    public override fun plus(context: CoroutineContext): CoroutineContext = context
    public override fun minusKey(key: Key<*>): CoroutineContext = this
    public override fun hashCode(): Int = 0
    public override fun toString(): String = "EmptyCoroutineContext"
}

//--------------------- internal impl ---------------------

// this class is not exposed, but is hidden inside implementations
// this is a left-biased list, so that `plus` works naturally
internal class CombinedContext(val left: CoroutineContext, val element: Element) : CoroutineContext {
    override fun <E : Element> get(key: Key<E>): E? {
        var cur = this
        while (true) {
            cur.element[key]?.let { return it }
            val next = cur.left
            if (next is CombinedContext) {
                cur = next
            } else {
                return next[key]
            }
        }
    }

    public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
        operation(left.fold(initial, operation), element)
    //CombinedContext的minusKey操作的逻辑是：https://blog.csdn.net/xufei5789651/article/details/122902980
    //1、先看element是否是匹配，如果匹配，那么element就是需要删除的元素，返回left，否则说明要删除的元素在left中，继续从left中删除对应的元素，根据left是否删除了要删除的元素转到2或3或4
    //2、如果left中不存在要删除的元素，那么当前CombinedContext就不存在要删除的元素，直接返回当前CombinedContext实例就行
    //3、如果left中存在要删除的元素，删除了这个元素后，left变为了空，那么直接返回当前CombinedContext的element就行
    //4、如果left中存在要删除的元素，删除了这个元素后，left不为空，那么组合一个新的CombinedContext返回
    public override fun minusKey(key: Key<*>): CoroutineContext {
        element[key]?.let { return left } // 注释1
        //left有可能是单个element，此时返回的的newLeft==left,表示遍历后没找到
        val newLeft = left.minusKey(key)
        return when {
            newLeft === left -> this // 注释2
            newLeft === EmptyCoroutineContext -> element // 注释3
            else -> CombinedContext(newLeft, element) // 注释4
        }
    }

    private fun size(): Int =
        if (left is CombinedContext) left.size() + 1 else 2

    private fun contains(element: Element): Boolean =
        get(element.key) == element

    private fun containsAll(context: CombinedContext): Boolean {
        var cur = context
        while (true) {
            if (!contains(cur.element)) return false
            val next = cur.left
            if (next is CombinedContext) {
                cur = next
            } else {
                return contains(next as Element)
            }
        }
    }

    override fun equals(other: Any?): Boolean =
        this === other || other is CombinedContext && other.size() == size() && other.containsAll(this)

    override fun hashCode(): Int = left.hashCode() + element.hashCode()

    override fun toString(): String =
        "[" + fold("") { acc, element ->
            if (acc.isEmpty()) element.toString() else acc + ", " + element
        } + "]"
}
