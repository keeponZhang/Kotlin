package cn.kotliner.coroutine.async

import ch10.ex2_1_3_ReflectionAPI2.counter
import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by benny on 5/29/17.
 */
//使用伴生对象的特点,构造函数传一个对象
class AsyncContext2 : AbstractCoroutineContextElement(MYKey), ContinuationInterceptor {
    val test = "keepon"

    //AbstractCoroutineContextElement需要一个key，类型是CoroutineContext.Key，最好是单例，
    //好难搞，这样处理就是为了拿到AsyncContext2的实例，通过对比key，相等的话直接转换，否则返回null
//    public override operator fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? =
//        if (this.key === key) this as E else null
    companion object MYKey : CoroutineContext.Key<AsyncContext2>

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        log("AsyncContext2 调用interceptContinuation啦啦啦")
        return continuation
    }
}