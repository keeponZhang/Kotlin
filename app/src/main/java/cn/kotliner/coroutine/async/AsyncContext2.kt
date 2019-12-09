package cn.kotliner.coroutine.async

import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//使用伴生对象的特点
class AsyncContext2 : AbstractCoroutineContextElement(MYKey) {
    val test = "keepon"

    companion object MYKey : CoroutineContext.Key<AsyncContext2>
}