package cn.kotliner.coroutine.async

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//Element实现了CoroutineContext,如果有伴生对象，直接调用类名，就是调用伴生对象，否则会报错
class DownloadContext(val url: String) : AbstractCoroutineContextElement(DownloadContext) {
    //DownloadContext.Key和DownloadContext都行
    //伴生对象的成员全局独一份
    //其实Key这里只是变量名，因为是静态变量，首字母可以大写
    companion object Key : CoroutineContext.Key<DownloadContext>
}