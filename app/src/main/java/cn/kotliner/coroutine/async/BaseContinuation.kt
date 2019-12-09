package cn.kotliner.coroutine.async

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
class BaseContinuation : Continuation<Unit> {
    override fun resumeWith(result: Result<Unit>) {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //EmptyCoroutineContext什么都没有做
    override val context: CoroutineContext = EmptyCoroutineContext
}