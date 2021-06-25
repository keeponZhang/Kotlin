package com.bennyhuo.kotlin

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 *createBy keepon
 */
fun main() {
    val asyncContext = AsyncContext()
    val asyncContext2 = DownloadContext("www.baidu.com2")
    val asyncContext3 = AsyncContext("chenmo3")
    val coroutineContext = asyncContext + asyncContext2
    coroutineContext + asyncContext3
    println("-----------")
}

class AsyncContext(val test: String = "keepon") : AbstractCoroutineContextElement(Key),
    ContinuationInterceptor {

    //AbstractCoroutineContextElement需要一个key，类型是CoroutineContext.Key，最好是单例，
    //好难搞，这样处理就是为了拿到AsyncContext2的实例，通过对比key，相等的话直接转换，否则返回null
//    public override operator fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? =
//        if (this.key === key) this as E else null
    companion object Key : CoroutineContext.Key<AsyncContext>

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        log("AsyncContext2 调用interceptContinuation啦啦啦")
        return continuation
    }
}

class DownloadContext(val url: String) : AbstractCoroutineContextElement(DownloadContext) {
    //DownloadContext.Key和DownloadContext都行
    //伴生对象的成员全局独一份
    //其实Key这里只是变量名，因为是静态变量，首字母可以大写
    companion object Key : CoroutineContext.Key<DownloadContext>
}