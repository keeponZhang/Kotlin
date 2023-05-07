package cn.kotliner.coroutine.async.begin

import cn.kotliner.coroutine.basic.BaseContinuation
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 * Time:2023-05-07 下午 6:34
 * Author:
 * Description:
 */
// suspend () -> Unit 会实例化成SuspendLambda
//lamda是继承Function1，被suspend修饰的会继承CoroutineImpl
// ContinuationKt.startCoroutine(block, (Continuation)(new BaseContinuation((CoroutineContext)EmptyCoroutineContext.INSTANCE)));
fun 我要开始协程啦BaseContinuation(block: suspend () -> Unit) {
    log("--------------")
    block.startCoroutine(BaseContinuation(EmptyCoroutineContext))
}
