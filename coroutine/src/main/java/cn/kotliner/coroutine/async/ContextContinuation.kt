package cn.kotliner.coroutine.async

import com.bennyhuo.kotlin.coroutines.utils.log
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
        log("ContextContinuation resume "+result)
    }
}