package com.bennyhuo.kotlin.coroutines.dispatcher

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

interface Dispatcher {
    //    只执行一段代码，可以这样
    fun dispatch(block: () -> Unit)
}

//DispatcherContext需要传入一个Dispatcher,interceptContinuation的continuation是BaseContinuationImpl
open class DispatcherContext(private val dispatcher: Dispatcher) : AbstractCoroutineContextElement(
        ContinuationInterceptor
), ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> =
            DispatchedContinuation(continuation, dispatcher)
}

//持有Continuation和Dispatcher，回调的时候用dispatcher切换，delegate是BaseContinuationImpl
private class DispatchedContinuation<T>(val delegate: Continuation<T>, val dispatcher: Dispatcher) :
        Continuation<T> {
    override val context = delegate.context

    init {
        log("delegate=$delegate")
    }

    override fun resumeWith(result: Result<T>) {
        dispatcher.dispatch {
            log("切换线程,delegate=$delegate")
            delegate.resumeWith(result)
        }
    }
}