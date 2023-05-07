package cn.kotliner.coroutine.async.begin

import cn.kotliner.coroutine.async.ContextContinuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * Time:2023-05-07 下午 6:34
 * Author:
 * Description:
 */
//协程 suspend 修饰
fun 我要开始协程啦自定义Context(
    context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    //可以组合多个context
    block.startCoroutine(ContextContinuation(context))
}