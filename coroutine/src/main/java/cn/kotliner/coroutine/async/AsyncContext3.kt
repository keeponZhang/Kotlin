package cn.kotliner.coroutine.async

import cn.kotliner.coroutine.common.log
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor

/**
 * Created by benny on 5/29/17.
 */
//使用伴生对象的特点,构造函数传一个对象
class AsyncContext3 : AbstractCoroutineContextElement(ContinuationInterceptor), ContinuationInterceptor {
    val test = "keepon"

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        log("AsyncContext3 调用interceptContinuation啦啦啦")
        return continuation
    }
}