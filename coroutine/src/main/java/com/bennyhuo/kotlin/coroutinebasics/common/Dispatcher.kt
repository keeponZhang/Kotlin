package com.bennyhuo.kotlin.coroutinebasics.common

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

interface Dispatcher {
    fun dispatch(block: () -> Unit)
}

//这里的key用的是ContinuationInterceptor，很重要
open class DispatcherContext(private val dispatcher: Dispatcher = DefaultDispatcher) :
        AbstractCoroutineContextElement(ContinuationInterceptor), ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> =
            DispatchedContinuation(continuation, dispatcher)
}

private class DispatchedContinuation<T>(val delegate: Continuation<T>, val dispatcher: Dispatcher) :
        Continuation<T> {
    override val context = delegate.context
//launch启动的时候会调用以
    override fun resumeWith(result: Result<T>) {
        dispatcher.dispatch {
            log("切换线程 delegeate=$delegate")
            delegate.resumeWith(result)
        }
    }
}

