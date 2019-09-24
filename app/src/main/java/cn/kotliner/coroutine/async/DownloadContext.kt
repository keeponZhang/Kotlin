package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//Element实现了CoroutineContext
class DownloadContext(val url: String): AbstractCoroutineContextElement(DownloadContext.Key){
    //伴生对象的成员全局独一份
    //其实Key这里只是变量名，因为是静态变量，首字母可以大写
    companion object Key: CoroutineContext.Key<DownloadContext>
}