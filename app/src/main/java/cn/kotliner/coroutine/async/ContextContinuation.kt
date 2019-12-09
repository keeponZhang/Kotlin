package cn.kotliner.coroutine.async

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//context 是父类继承下来的
class ContextContinuation(override val context: CoroutineContext = EmptyCoroutineContext) :
    Continuation<Unit> {
    override fun resumeWith(result: Result<Unit>) {
    }
}