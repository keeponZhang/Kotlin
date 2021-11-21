package com.bennyhuo.kotlin.coroutines.scope

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

private class SupervisorCoroutine<T>(context: CoroutineContext, continuation: Continuation<T>) :
        ScopeCoroutine<T>(context, continuation) {
    //    主要是异常传播的处理不同，这里不处理子协程的异常
    override fun handleChildException(e: Throwable): Boolean {
        return false
    }
}

suspend fun <R> supervisorScope(block: suspend CoroutineScope.() -> R): R =
        suspendCoroutine { continuation ->
            val coroutine = SupervisorCoroutine(continuation.context, continuation)
            block.startCoroutine(coroutine, coroutine)
        }

//suspend fun <R> coroutineScope(block: suspend CoroutineScope.() -> R): R =
//        suspendCoroutine { continuation ->
////        因为用的是父类的continuation.context
//            val coroutine = ScopeCoroutine(continuation.context, continuation)
////        这里receiver是CoroutineScope，所以AbstractCoroutine实现了CoroutineScope，拿到的其实就是AbstractCoroutine的CoroutineContext
//            block.startCoroutine(coroutine, coroutine)
//        }
