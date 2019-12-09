package cn.kotliner.coroutine.async


import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * Created by benny on 5/29/17.
 */
//AbstractCoroutineContextElement 其实就是重写了key
//这里其实就是自定义了自己的拦截器，所以需要重写key（所有拦截器都用同一个key（ContinuationInterceptor））
//通过拦截器实现UiCotinuationWrapper代理返回
class AsyncContext : AbstractCoroutineContextElement(ContinuationInterceptor),
    ContinuationInterceptor {

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        //这样不行，因为所有的interceptor都用一个key,要给其他的key篡改的机会
//        return UiCotinuationWrapper(continuation)
        val fold = continuation.context.fold(continuation) {
            //每一步篡改后的continuation，element要篡改的对象
            continuation, element ->
            println("continuation = " + continuation + " element = " + element)
            //注意element != this 不等于自己
            if (element != this && element is ContinuationInterceptor) {
                element.interceptContinuation(continuation)
            } else {
                continuation
            }
        }
        println("fold = " + fold)
        return UiCotinuationWrapper(fold)
    }
}