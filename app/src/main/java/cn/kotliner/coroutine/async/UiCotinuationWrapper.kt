package cn.kotliner.coroutine.async

import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation

/**
 * Created by benny on 5/29/17.
 */
//可以在这里进行线程切换
class UiCotinuationWrapper<T>(val continuation: Continuation<T>) : Continuation<T> {
    override fun resume(value: T) {
        continuation.resume(value)
    }

    override fun resumeWithException(exception: Throwable) {
        continuation.resumeWithException(exception)
    }

    override val context = continuation.context
}
