package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
class DownloadContext(val url: String): AbstractCoroutineContextElement(Key){
    //伴生对象的成员全局独一份
    companion object Key: CoroutineContext.Key<DownloadContext>
}