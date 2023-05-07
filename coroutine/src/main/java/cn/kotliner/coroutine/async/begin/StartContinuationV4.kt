package cn.kotliner.coroutine.async.begin

import cn.kotliner.coroutine.async.ContextContinuation
import cn.kotliner.coroutine.async.DownloadContext
import cn.kotliner.coroutine.ui.LOGO_URL
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * Time:2023-05-07 下午 6:34
 * Author:
 * Description:
 */
fun 我要开始协程啦自定义ContextAndDownloadContext(
    context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    //可以组合多个context
    //context + DownloadContext(LOGO_URL) =DownloadContext(LOGO_URL)
    block.startCoroutine(ContextContinuation(context + DownloadContext(LOGO_URL)))
}