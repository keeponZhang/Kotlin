package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//context 是父类继承下来的
class ContextContinuation(override val context: CoroutineContext = EmptyCoroutineContext) :
    Continuation<Unit> {
    override fun resumeWithException(exception: Throwable) {
    }

    override fun resume(value: Unit) {
    }
}