package cn.kotliner.coroutine.async

import javax.swing.SwingUtilities
import kotlin.coroutines.experimental.Continuation

/**
 * Created by benny on 5/29/17.
 */
//可以在这里进行线程切换
class UiCotinuationWrapper<T>(val continuation: Continuation<T>): Continuation<T>{
    override val context = continuation.context

    override fun resume(value: T) {
        SwingUtilities.invokeLater { continuation.resume(value) }
    }

    override fun resumeWithException(exception: Throwable) {
        SwingUtilities.invokeLater { continuation.resumeWithException(exception) }
    }

}
