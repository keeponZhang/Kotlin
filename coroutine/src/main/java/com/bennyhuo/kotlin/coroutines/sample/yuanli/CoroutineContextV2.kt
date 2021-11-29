/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package com.bennyhuo.kotlin.coroutines.sample.yuanli

import com.bennyhuo.kotlin.coroutines.sample.yuanli.CoroutineContextV2.KeyV2
import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * Persistent context for the coroutine. It is an indexed set of [ElementV2] instances.
 * An indexed set is a mix between a set and a map.
 * Every element in this set has a unique [KeyV2]. Keys are compared _by reference_.
 */
@SinceKotlin("1.1")
public interface CoroutineContextV2 {
    /**
     * Returns the element with the given [key] from this context or `null`.
     * Keys are compared _by reference_, that is to get an element from the context the reference to its actual key
     * object must be presented to this function.
     */
    public operator fun <E : ElementV2> get(key: KeyV2<E>): E?

    /**
     * Accumulates entries of this context starting with [initial] value and applying [operation]
     * from left to right to current accumulator value and each element of this context.
     */
    public fun <R> fold(initial: R, operation: (R, ElementV2) -> R): R
    public fun <R> fold2(initial: R, operation: (R, ElementV2) -> R): R? {
        return null
    }

    /**
     * Returns a context containing elements from this context and elements from  other [context].
     * The elements from this context with the same key as in the other one are dropped.
     */
//    public operator fun plus(context: CoroutineContextV2): CoroutineContextV2 =
//            if (context === EmptyCoroutineContextV2) this else {// fast path -- avoid lambda creation
//                context.fold(this) { acc, element ->
//                    val removed = acc.minusKey(element.key)
//                    if (removed === EmptyCoroutineContextV2) element else {
//                        // make sure interceptor is always last in the context (and thus is fast to get when present)
//                        val interceptor = removed[ContinuationInterceptor]
//                        val combinedContext =
//                                if (interceptor == null) CombinedContext(removed, element) else {
//                                    val left = removed.minusKey(ContinuationInterceptor)
//                                    if (left === EmptyCoroutineContextV2) CombinedContext(
//                                            element,
//                                            interceptor
//                                    ) else
//                                        CombinedContext(CombinedContext(left, element), interceptor)
//                                }
//                        combinedContext
//                    }
//                }
//            }
    public operator fun plus(context: CoroutineContextV2): CoroutineContextV2 =
            if (context === EmptyCoroutineContextV2) this else {// fast path -- avoid lambda creation
                context.fold(this) { acc, element ->
                    val removed = acc.minusKey(element.key, element)
                    if (removed === EmptyCoroutineContextV2) {
//                        log("plus 后 ----------element=$element")
                        element
                    } else {
                        // make sure interceptor is always last in the context (and thus is fast to get when present)
                        val interceptor = removed[ContinuationInterceptorV2]
                        val combinedContextV2 =
                                if (interceptor == null) {
                                    CombinedContextV2(removed, element)
                                } else {
                                    val left = removed.minusKey(ContinuationInterceptorV2, element)
                                    if (left === EmptyCoroutineContextV2) {
                                        CombinedContextV2(
                                                element,
                                                interceptor
                                        )
                                    } else {
                                        CombinedContextV2(CombinedContextV2(left, element),
                                                interceptor)
                                    }
                                }
//                        log("plus 后 combinedContextV2=$combinedContextV2")
                        combinedContextV2
                    }
                }
            }

    //重要！！！！！！！！！：
//协程context是个非常fp的、有头(head)有尾(tail)的list，换个比较通俗的词语来讲就是 单 向 链 表。
//fold就是非常fp的对list进行遍历的函数，就是遍历而已，不会对list进行修改。
//plus就是用于链接两个list的函数，返回一个新的list，不会对原来的两个list进行修改。
//但是plus需要保证最终的结果里key不会重复，所以需要使用minusKey来去重。
    //重要！！！！！！！！！！！！！
//加号运算符将CoroutineContext实例相互结合。它会合并它们所包含的元素，
//用操作符右边的上下文中的元素覆盖左边的上下文中的元素，很像Map上的行为。
//[加号运算符]返回一个包含来自这个上下文的元素和其他上下文的元素的上下文。这个上下文中与另一个上下文中Key值相同的元素会被删除。
//(Dispatchers.Main, “name”) + (Dispatchers.IO) = (Dispatchers.IO, “name”)
//    public operator fun plus(context: CoroutineContextV2): CoroutineContextV2 =
//            //如果要相加的CoroutineContext为空，那么不做任何处理，直接返回
//            if (context === EmptyCoroutineContextV2) this else
//            //如果要相加的CoroutineContext不为空，那么对它进行fold操作
////注释1，相加的时候，是被加的，即是右边的调用fold，传入调用者，如果右边的是element,此时acc就是传入的参数，就是this，
////注释2：一般来说，context都是Element
//                context.fold(
//                        this) { acc, element -> //我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element
//                    //首先从左边CoroutineContext中删除右边的这个element,removed是表示删除之后的
//                    val removed = acc.minusKey(element.key, element)
//                    //返回了EmptyCoroutineContextV2，表示左右的key是一样的，相加后返回右边那个就好，否则返回左边这个，即调用者
//                    if (removed === EmptyCoroutineContextV2) {
//                        log("plus 后 ----------element=$element")
//                        element
//                    } else {
//                        //如果removed不为空，说明左边CoroutineContext删除了和element相同的元素后还有其他元素，那么构造一个新的CombinedContext返回
//                        val combinedContextV2 = CombinedContextV2(removed, element)
//
//                        log("plus 后 combinedContextV2=$combinedContextV2")
//                        combinedContextV2
//                    }
//                }

    /**
     * Returns a context containing elements from this context, but without an element with
     * the specified [key]. Keys are compared _by reference_, that is to remove an element from the context
     * the reference to its actual key object must be presented to this function.
     */
    public fun minusKey(key: KeyV2<*>, elementV2: ElementV2): CoroutineContextV2

    /**
     * An element of the [CoroutineContextV2]. An element of the coroutine context is a singleton context by itself.
     */


    /**
     * Key for the elements of [CoroutineContextV2]. [E] is a type of element with this key.
     * Keys in the context are compared _by reference_.
     */
    public interface KeyV2<E : ElementV2>

    fun getString(): String {
        return ""
    }
}
