package com.bennyhuo.kotlin.coroutines.dispatcher

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

interface Dispatcher {
//    只执行一段代码，可以这样
    fun dispatch(block: ()->Unit)
}
//DispatcherContext需要传入一个Dispatcher
open class DispatcherContext(private val dispatcher: Dispatcher) : AbstractCoroutineContextElement(
    ContinuationInterceptor
), ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T>
            = DispatchedContinuation(continuation, dispatcher)
}
//持有Continuation和Dispatcher，回调的时候用dispatcher切换
private class DispatchedContinuation<T>(val delegate: Continuation<T>, val dispatcher: Dispatcher) : Continuation<T>{
    override val context = delegate.context

    override fun resumeWith(result: Result<T>) {
        dispatcher.dispatch {
            delegate.resumeWith(result)
        }
    }
}