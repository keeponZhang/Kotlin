package com.bennyhuo.kotlin.coroutines

import com.bennyhuo.kotlin.coroutines.context.CoroutineName
import com.bennyhuo.kotlin.coroutines.core.*
import com.bennyhuo.kotlin.coroutines.dispatcher.DispatcherContext
import com.bennyhuo.kotlin.coroutines.dispatcher.Dispatchers
import com.bennyhuo.kotlin.coroutines.scope.CoroutineScope
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

private var coroutineIndex = AtomicInteger(0)
fun CoroutineScope.launchV0(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend () -> Unit
): Job {
    //kotlin 1.2的时候completion是传进来的，所以StandardCoroutine是一个Continuation
    //注释1：CoroutineScope和Continuation里面都有一个
//    注释2：newCoroutineContext是返回混合后的context
   val completion = StandardCoroutine(newCoroutineContext(context))
//    这里receiver是实现了CoroutineScope的CoroutineContext
    block.startCoroutine(completion)
    return completion
}

fun CoroutineScope.launchV1(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend () -> Unit
): Job {
    //kotlin 1.2的时候completion是传进来的，所以StandardCoroutine是一个Continuation
    //注释1：CoroutineScope和Continuation里面都有一个
    val completion = StandardCoroutine(context)
//    这里receiver是实现了CoroutineScope的CoroutineContext
    block.startCoroutine(completion)
    return completion
}
fun CoroutineScope.launchV2(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend () -> String
): Job {
    //kotlin 1.2的时候completion是传进来的，所以StandardCoroutine是一个Continuation
    //注释1：CoroutineScope和Continuation里面都有一个
//    注释2：newCoroutineContext是返回混合后的context
//    val completion = StandardCoroutine(newCoroutineContext(context))
    val completion = StringCoroutine(context)
//    这里receiver是实现了Coroutin eScope的CoroutineContext
//    这里会执行block代码块里的代码啦
    block.startCoroutine(completion)
    return completion
}

fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
): Job {
    //kotlin 1.2的时候completion是传进来的，所以StandardCoroutine是一个Continuation
    //注释1：CoroutineScope和Continuation里面都有一个
//    注释2：newCoroutineContext是返回混合后的context
    val newCoroutineContext = newCoroutineContext(context)
    val completion = StandardCoroutine(newCoroutineContext)
//    这里receiver是实现了CoroutineScope的CoroutineContext
//   作为参数传进block里面，第一个参数作为receiver是作为CoroutineScope
    block.startCoroutine(completion, completion)
    return completion
}

fun <T> CoroutineScope.async(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    val completion = DeferredCoroutine<T>(newCoroutineContext(context))
    block.startCoroutine(completion, completion)
    return completion
}

fun CoroutineScope.newCoroutineContext(context: CoroutineContext): CoroutineContext {
//    scopeContext是CoroutineScope里面的，父协程的（注意这里），CoroutineName用于打印名字
    val combined =
        scopeContext + context + CoroutineName("@coroutine#${coroutineIndex.getAndIncrement()}")
    return if (combined !== Dispatchers.Default && combined[ContinuationInterceptor] == null)
        combined + Dispatchers.Default else combined
}

//runBlocking最后返回一个值，T
fun <T> runBlocking(context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> T): T {
    val eventQueue = BlockingQueueDispatcher()
    //这里传进去了dispatcher
    val newContext = context + DispatcherContext(eventQueue)
    val completion = BlockingCoroutine<T>(newContext, eventQueue)
    block.startCoroutine(completion)
    return completion.joinBlocking()
}