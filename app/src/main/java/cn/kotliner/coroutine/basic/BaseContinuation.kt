package cn.kotliner.coroutine.basic

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


/**
 * Created by benny on 5/29/17.
 */
class BaseContinuation: Continuation<Unit> {
    override fun resumeWith(result: Result<Unit>) {
    }

    override val context: CoroutineContext = EmptyCoroutineContext



}