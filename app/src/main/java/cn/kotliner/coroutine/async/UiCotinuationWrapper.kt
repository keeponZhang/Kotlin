package cn.kotliner.coroutine.async

import cn.kotliner.coroutine.common.log
import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.EmptyCoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//可以在这里进行线程切换
class UiCotinuationWrapper<T>(val continuation: Continuation<T>) : Continuation<T> {
    override fun resume(value: T) {
        SwingUtilities.invokeLater { continuation.resume(value) }
        log("UiCotinuationWrapper resume "+continuation)
    }

    override fun resumeWithException(exception: Throwable) {
        SwingUtilities.invokeLater {
            continuation.resumeWithException(exception)
        }
        log ("UiCotinuationWrapper resumeWithException "+continuation)
    }

    //应该用人传进来的context
        override val context = continuation.context
//    override val context = EmptyCoroutineContext
}
