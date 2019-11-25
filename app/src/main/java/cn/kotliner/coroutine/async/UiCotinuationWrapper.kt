package cn.kotliner.coroutine.async

import javax.swing.SwingUtilities
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Created by benny on 5/29/17.
 */
//可以在这里进行线程切换
class UiCotinuationWrapper<T>(val continuation: Continuation<T>): Continuation<T>{
    override fun resumeWith(result: Result<T>) {
        continuation.resumeWith(result)
    }

    override val context = continuation.context

}
