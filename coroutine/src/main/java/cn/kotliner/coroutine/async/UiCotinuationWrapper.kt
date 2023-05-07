package cn.kotliner.coroutine.async

import com.bennyhuo.kotlin.coroutines.utils.log
import javax.swing.SwingUtilities
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

/**
 * Created by benny on 5/29/17.
 */
//可以在这里进行线程切换
class UiCotinuationWrapper<T>(val continuation: Continuation<T>) : Continuation<T> {
    //启动的时候就会调用，原因 createCoroutineUnchecked(completion).resume(Unit)

    //应该用人传进来的context
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        log("UiCotinuationWrapper resumeWithException " + continuation)
        SwingUtilities.invokeLater {
            log("UiCotinuationWrapper resumeWithException 切换线程后 " + continuation)
            continuation.resumeWith(result)
        }
    }
//    override val context = EmptyCoroutineContext
}
