package com.bennyhuo.kotlin.coroutines.scope

import com.bennyhuo.kotlin.coroutines.Job
import com.bennyhuo.kotlin.coroutines.core.AbstractCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

interface CoroutineScope {
    val scopeContext: CoroutineContext
}

internal class ContextScope(context: CoroutineContext): CoroutineScope {
    override val scopeContext: CoroutineContext = context
}

operator fun CoroutineScope.plus(context: CoroutineContext): CoroutineScope =
    ContextScope(scopeContext + context)

fun CoroutineScope.cancel(){
    val job = scopeContext[Job] ?: error("Scope cannot be cancelled because it does not have a job: $this")
    job.cancel()
}

//通过这个启动的叫协同作用域
suspend fun <R> coroutineScope(block: suspend CoroutineScope.() -> R): R =
    suspendCoroutine {
        continuation ->
//        因为用的是父类的continuation.context
        val coroutine = ScopeCoroutine(continuation.context, continuation)
//        这里receiver是CoroutineScope，所以AbstractCoroutine实现了CoroutineScope，拿到的其实就是AbstractCoroutine的CoroutineContext
        block.startCoroutine(coroutine, coroutine)
    }

//continuation注意，这里起始就是静态代理
internal open class ScopeCoroutine<T>(context: CoroutineContext,
                                      val continuation: Continuation<T>)
    : AbstractCoroutine<T>(context) {
    override fun resumeWith(result: Result<T>) {
        super.resumeWith(result)
        continuation.resumeWith(result)
    }
}