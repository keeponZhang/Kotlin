package com.bennyhuo.kotlin.coroutine.ch03

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * Wrapper for `suspend fun main` and `@Test suspend fun testXXX` functions.
 */
@SinceKotlin("1.3")
internal fun runSuspend(block: suspend () -> Unit) {
    val run = RunSuspend()
    block.startCoroutine(run)
//    run.await()
}

private class RunSuspend : Continuation<Unit> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    //-Xallow-result-return-type
    var result: Result<Unit>? = null

    override fun resumeWith(result: Result<Unit>) = synchronized(this) {
        this.result = result
        log("resumeWith")
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") (this as Object).notifyAll()
    }

    fun await() = synchronized(this) {
        while (true) {
            val result = this.result
            log("await-------$result---")
            when (result) {
                null -> @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN") (this as Object).wait()
                else -> {
                    result.getOrThrow() // throw up failure
                    return
                }
            }
        }
    }
}