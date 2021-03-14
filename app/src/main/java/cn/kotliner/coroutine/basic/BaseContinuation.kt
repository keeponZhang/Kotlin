package cn.kotliner.coroutine.basic

import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
class BaseContinuation : Continuation<Unit> {
    override fun resumeWithException(exception: Throwable) {
        log("BaseContinuation resumeWithException "+exception)
    }

    override fun resume(value: Unit) {
        log("BaseContinuation resume  " + value)
    }

    override val context: CoroutineContext = EmptyCoroutineContext
}