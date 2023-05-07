package cn.kotliner.coroutine.async.begin

import cn.kotliner.coroutine.async.AsyncContext
import cn.kotliner.coroutine.async.AsyncContext3
import cn.kotliner.coroutine.async.ContextContinuation
import kotlin.coroutines.startCoroutine

/**
 * Time:2023-05-07 下午 6:34
 * Author:
 * Description:
 */
fun 我要开始协程啦TwoAsyncContextV2(
    block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    block.startCoroutine(ContextContinuation(AsyncContext() + AsyncContext3()))
}