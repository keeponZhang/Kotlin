/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package cn.kotliner.coroutine.ui.operatorSample.custom

import cn.kotliner.coroutine.ui.operatorSample.custom.CoroutineContext.Element
import cn.kotliner.coroutine.ui.operatorSample.custom.CoroutineContext.Key

/**
 * Persistent context for the coroutine. It is an indexed set of [Element] instances.
 * An indexed set is a mix between a set and a map.
 * Every element in this set has a unique [Key].
 */
@SinceKotlin("1.3")
public interface CoroutineContext {
    var name: String

    /**
     * Returns the element with the given [key] from this context or `null`.
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
    //注释：右边被加的那个调用fold方法，fold的初始值传入的是this，elementV1+elementV2，acc是elementV1，element是elementV2   https://blog.csdn.net/xufei5789651/article/details/122902980
    // 左边那个调用minusKey方法，并且传入的是右边被加的Key，这里分2个情况，1如果左边的是element，如果左边的Key与右边的Key相等，返回EmptyCoroutineContext，否则相当于没减成功，返回当前element
    //注释0：如果加的是EmptyCoroutineContext，返回的是this，被加的那个（左边那个）
    //注释1:我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element
    //注释2:从左边CoroutineContext中删除右边的这个element，如果左边没有相同的，则还是返回左边那个(acc)
    //注释3:如果removed为空，说明左边CoroutineContext删除了和element相同的元素后为空，那么返回右边的element即可
    // 注释4:如果removed不为空，说明左边CoroutineContext删除了和element相同的元素后还有其他元素，那么构造一个新的CombinedContext返回
    //注释5:左边的元素没有拦截器，直接闯将一个CombinedContext，原来的元素为left，被加的为element
    // 注释6-1：左边只有一个ContinuationInterceptor，创建CombinedContext，interceptor放在最右边
    // 注释6-2：
    public operator fun plus(context: CoroutineContext): CoroutineContext =
        if (context === EmptyCoroutineContext) this else // 注释0
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

    //例子2： val case2 = CoroutineName( "c1" ) + CoroutineName("c2")
    //因为key相同，removed返回的是EmptyCoroutineContext，所以只会保留CoroutineName

    //例子3：CoroutineName("c1") + Job()
    //因为key不同，removed返回的是CoroutineName，此时removed[ContinuationInterceptor]也返回null，所以CombinedContext(CoroutineName("c1") , Job() )


    //例子4：Dispatchers.Main + Job()
    //因为key不同，removed返回的是Dispatchers.Main，此时removed[ContinuationInterceptor]也返回Dispatchers.Main，left=removed.minusKey(ContinuationInterceptor)
    //也返回left =EmptyCoroutineContext,所以CombinedContext（Job()，Dispatchers.Main）

    //例子5：
    //val case4 = Dispatchers.Main + Job()
    //CombinedContext（Job()，Dispatchers.Main）
    //case5 当前的CoroutineContext有ContinuationInterceptor和其他
    //val case5 = case4 + CoroutineName("c5"）
    //结果: Job <- CoroutineName("c5") <- Dispatchers.Main。Dispatchers.Main 在链表头部，其它的采用头插法。
    //分析：
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
        override var name: String


        public override operator fun <E : Element> get(key: Key<E>): E? =
            @Suppress("UNCHECKED_CAST")
            if (this.key == key) this as E else null

        public override fun <R> fold(initial: R, operation: (R, Element) -> R): R {
            println("0 -----Element fold initial=$initial element=${this.name}")
            return operation(initial, this)
        }


        public override fun minusKey(key: Key<*>): CoroutineContext =
            if (this.key == key) EmptyCoroutineContext else this
    }
}
