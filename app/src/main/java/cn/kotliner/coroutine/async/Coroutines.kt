package cn.kotliner.coroutine.async

import cn.kotliner.coroutine.basic.BaseContinuation
import cn.kotliner.coroutine.ui.LOGO_URL
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.coroutines.experimental.EmptyCoroutineContext
import kotlin.coroutines.experimental.startCoroutine

/**
 * Created by benny on 5/29/17.
 */
fun 我要开始协程啦BaseContinuation(block: suspend () -> Unit) {
    block.startCoroutine(BaseContinuation())
}

fun 我要开始协程啦OnlyAsyncContext3_(
        block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    block.startCoroutine(ContextContinuation(AsyncContext()))
}


//协程 suspend 修饰
fun 我要开始协程啦自定义Context使用ContextContinuation_4_1(
        context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    //可以组合多个context
    block.startCoroutine(ContextContinuation(context))
}

fun 我要开始协程啦自定义Context使用ContextContinuation4_2(
        context: CoroutineContext = EmptyCoroutineContext, block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    //可以组合多个context
    //context + DownloadContext(LOGO_URL) =DownloadContext(LOGO_URL)
    block.startCoroutine(ContextContinuation(context + DownloadContext(LOGO_URL)))
}


//AsyncContext() + AsyncContext2()+AsyncContext3()
//相同key会覆盖,一共只会保留一个key，上面会AsyncContext3生效
//AsyncContext2() + AsyncContext() + AsyncContext3()
//上面AsyncContext3生效
//AsyncContext2() + AsyncContext()
//AsyncContext生效
//AsyncContext() + AsyncContext2()
//AsyncContext生效
//AsyncContext2()
//没走到interceptContinuation方法
//AsyncContext3() + AsyncContext()
//AsyncContext生效
//AsyncContext() + AsyncContext3()
//AsyncContext3生效
fun 我要开始协程啦TwoAsyncContext3_2(
        block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    block.startCoroutine(ContextContinuation(AsyncContext() + AsyncContext3()))
}

//相同key会覆盖,其他的context只能通过拦截器调用
fun 我要开始协程啦TwoAsyncContext3_3(
        block: suspend () -> Unit
) {
    //被suspend修饰的lambda表达式才有startCoroutine方法
    block.startCoroutine(ContextContinuation(AsyncContext3() + AsyncContext()))
}

fun main(args: Array<String>) {
    //没有这个
//    GlobalScope.launch {
//        println("codesrun in coroutine scope")
//
//    }
}

