package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
class BaseContinuation : Continuation<Unit> {
    override fun resume(value: Unit) {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun resumeWithException(exception: Throwable) {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //EmptyCoroutineContext什么都没有做
    override val context: CoroutineContext = EmptyCoroutineContext
}