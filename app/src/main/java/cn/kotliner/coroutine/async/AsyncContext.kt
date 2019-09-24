package cn.kotliner.coroutine.async

import kotlin.coroutines.experimental.AbstractCoroutineContextElement
import kotlin.coroutines.experimental.Continuation
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * Created by benny on 5/29/17.
 */
class AsyncContext: AbstractCoroutineContextElement(ContinuationInterceptor.Key), ContinuationInterceptor{

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        //这样不行，因为所有的interceptor都用一个key,要给其他的key篡改的机会
//        return UiCotinuationWrapper(continuation)
        return UiCotinuationWrapper(continuation.context.fold(continuation){
            //每一步篡改后的continuation，element要篡改的对象
            continuation, element ->
            if(element != this && element is ContinuationInterceptor){
                element.interceptContinuation(continuation)
            }else{
                continuation
            }
        })
    }

}