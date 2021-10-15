///*
// * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
// * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
// */
//
//package kotlin.coroutines.doc
//
//import kotlin.coroutines.doc.CombinedContextV2
//
///**
// * Persistent context for the coroutine. It is an indexed set of [Element] instances.
// * An indexed set is a mix between a set and a map.
// * Every element in this set has a unique [Key]. https://blog.csdn.net/xx23x/article/details/107976319
// */
//@SinceKotlin("1.3")
//public interface CoroutineContext {
//    /**
//     * Returns the element with the given [key] from this context or `null`.
//     */
//    public operator fun <E : Element> get(key: Key<E>): E?
//
//    /**
//     * Accumulates entries of this context starting with [initial] value and applying [operation]
//     * from left to right to current accumulator value and each element of this context.
//     */


//    /**
//     * Returns a context containing elements from this context and elements from  other [context].
//     * The elements from this context with the same key as in the other one are dropped.
//     */

//    public operator fun plus(context: CoroutineContext): CoroutineContext =
//        if (context === EmptyCoroutineContext) this else // fast path -- avoid lambda creation
//            context.fold(this) { acc, element ->
//                val removed = acc.minusKey(element.key)
//                if (removed === EmptyCoroutineContext) element else {
//                    // make sure interceptor is always last in the context (and thus is fast to get when present)
//                    val interceptor = removed[ContinuationInterceptor]
//                    if (interceptor == null) CombinedContextV2(removed, element) else {
//                        val left = removed.minusKey(ContinuationInterceptor)
//                        if (left === EmptyCoroutineContext) CombinedContextV2(element, interceptor) else
//                            CombinedContextV2(CombinedContextV2(left, element), interceptor)
//                    }
//                }
//            }
//

//它是一个聚集函数，提供了从left到right遍历CoroutineContext中每一个Element的能力，并对每一个Element做operation操作
//    public fun <R> fold(initial: R, operation: (R, Element) -> R): R
//
//    //CombinedContext的fold操作的逻辑是：先对left做fold操作，把left做完fold操作的的返回结果和element做operation操作
//    public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
//        operation(left.fold(initial, operation), element)（注意，这里是一层层fold进去，一直向左）


//     Element的fold操作:Element的fold方法就是单纯的将自己和方法调用者（即最最外层的CoroutineContext对象，也就是一开始调用CombinedContext的fold方法的那个变量，
//     这个变量可能是一个CoroutineContext，也可能是一个CombinedContext，一般应该就是一个CombinedContext）传进了operation代码块里
//  public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
//            operation(initial, this)  (initial其实就是左边+的）

//   A+B+C
//   1.B.fold(A){operation(A,B)} 此时acc=A, element=B，CombinedContext(A, B)
//   2.CombinedContextAB(A, B)+C    C.fold(CombinedContextAB(A, B)){acc=A.fold(CombinedContextAB, operation)}
//public operator fun plus(context: CoroutineContext): CoroutineContext =
//    //如果要相加的CoroutineContext为空，那么不做任何处理，直接返回
//    if (context === EmptyCoroutineContext) this else
//    //如果要相加的CoroutineContext不为空，那么对它进行fold操作
//        context.fold(this) { acc, element -> //我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element
//            //首先从左边CoroutineContext中删除右边的这个element
//            val removed = acc.minusKey(element.key)
//            //如果removed为空，说明左边CoroutineContext删除了和element相同的元素后为空，那么返回右边的element即可
//            if (removed === EmptyCoroutineContext) element else {
//                //如果removed不为空，说明左边CoroutineContext删除了和element相同的元素后还有其他元素，那么构造一个新的CombinedContext返回
//                return CombinedContext(removed, element)
//            }
//        }

//    /**
//     * Returns a context containing elements from this context, but without an element with
//     * the specified [key].
//     */
//    public fun minusKey(key: Key<*>): CoroutineContext
//
//    /**
//     * Key for the elements of [CoroutineContext]. [E] is a type of element with this key.
//     */
//    public interface Key<E : Element>
//
//    /**
//     * An element of the [CoroutineContext]. An element of the coroutine context is a singleton context by itself.
//     */
//    public interface Element : CoroutineContext {
//        /**
//         * A key of this coroutine context element.
//         */
//        public val key: Key<*>
//
//Element的get方法逻辑：如果key和自己的key匹配，那么自己就是要找的Element，返回自己，否则返回null
//        public override operator fun <E : Element> get(key: Key<E>): E? =
//            @Suppress("UNCHECKED_CAST")
//            if (this.key == key) this as E else null


///Element的fold方法逻辑：对传入的initial和自己做operation操作
//        public override fun <R> fold(initial: R, operation: (R, Element) -> R): R =
//            operation(initial, this)
////if (this.key == key) EmptyCoroutineContext

//  //Element的minusKey方法逻辑：如果key和自己的key匹配，那么自己就是要删除的Element，
//  返回EmptyCoroutineContext(表示删除了自己)，否则说明自己不需要被删除，返回自己
//        public override fun minusKey(key: Key<*>): CoroutineContext =
//            if (this.key == key) EmptyCoroutineContext else this
//    }
//}
