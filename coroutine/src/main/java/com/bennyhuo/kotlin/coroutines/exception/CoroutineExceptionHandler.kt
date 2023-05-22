package com.bennyhuo.kotlin.coroutines.exception

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext
//CoroutineExceptionHandler也是一个Element
interface CoroutineExceptionHandler: CoroutineContext.Element {
    companion object Key: CoroutineContext.Key<CoroutineExceptionHandler>

    fun handleException(context: CoroutineContext, exception: Throwable)
}
// handler: (CoroutineContext, Throwable) -> Unit 把单一接口转成函数
//handler就是一个高阶函数，block回调，CoroutineContext就是回调出来的CoroutineContext
//这样写外面就不用继承CoroutineExceptionHandler
inline fun coroutineExceptionHandler(crossinline handler: (CoroutineContext, Throwable) -> Unit):
        CoroutineExceptionHandler =
    object : AbstractCoroutineContextElement(CoroutineExceptionHandler), CoroutineExceptionHandler {
        override fun handleException(context: CoroutineContext, exception: Throwable) {
            handler.invoke(context, exception)
        }
    }