package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor
import kotlin.coroutines.experimental.CoroutineContext

/**
 * createBy	 keepon
 */
///key复写的是CoroutineContext.Element里的，而不是ContinuationInterceptor里的 companion object Key
class Interceptor(override val key: CoroutineContext.Key<Interceptor>) : ContinuationInterceptor {
    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return UiCotinuationWrapper(continuation)
    }
}