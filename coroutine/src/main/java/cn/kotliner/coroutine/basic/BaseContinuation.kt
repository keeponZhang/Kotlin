package cn.kotliner.coroutine.basic

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
class BaseContinuation(override val context: CoroutineContext) : Continuation<Unit> {
    override fun resumeWith(result: Result<Unit>) {
        log("BaseContinuation resume  " + result)
    }
}