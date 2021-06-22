package com.bennyhuo.kotlin.coroutinebasics.core

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * createBy	 keepon
 */
/**
 * Wrapper for `suspend fun main` and `@Test suspend fun testXXX` functions.
 */
//真正的话，这里是编译器生成的
fun main1(continuation: Continuation<Unit>): Any? {
    return println("Hello")
}

fun main() {
    //block相当于::main1 as suspend () -> Unit
    runSuspend(::main1 as suspend () -> Unit)
}

@SinceKotlin("1.3")
internal fun runSuspend(block: suspend () -> Unit) {
    val run: RunSuspend = RunSuspend()
    block.startCoroutine(run)
    //Continuation
    run.await()
}

private class RunSuspend : Continuation<Unit> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    //-Xallow-result-return-type
    var result: Result<Unit>? = null

    override fun resumeWith(result: Result<Unit>) = synchronized(this) {
        this.result = result
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") (this as Object).notifyAll()
    }

    fun await() = synchronized(this) {
        while (true) {
            when (val result = this.result) {
                null -> @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") (this as Object).wait()
                else -> {
                    result.getOrThrow() // throw up failure
                    return
                }
            }
        }
    }
}
