package com.bennyhuo.kotlin.coroutinebasics.eg.lua

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

//a->b的过程中,a先yield
class SymCoroutine<T>(
        var customName: String? = "默认",
        override
        val context: CoroutineContext = EmptyCoroutineContext,
        private val block: suspend SymCoroutine<T>.SymCoroutineBody.(T) -> Unit
) : Continuation<T> {

    companion object {
        //属性会生成外部类的私有静态变量
        lateinit var main: SymCoroutine<Any?>
        var keepon: String? = null

        //带lateinit会生成公有静态变量
        lateinit var keepon2: String

        //方法还是内部类的方法
        suspend fun main(block: suspend SymCoroutine<Any?>.SymCoroutineBody.() -> Unit) {
            SymCoroutine<Any?> { block() }.also { main = it }.start(Unit)
        }

        fun <T> create(
                customName: String? = "默认",
                context: CoroutineContext = EmptyCoroutineContext,
                block: suspend SymCoroutine<T>.SymCoroutineBody.(T) -> Unit
        ): SymCoroutine<T> {
            return SymCoroutine(customName, context, block)
        }
    }

    inner class SymCoroutineBody {
        //假设a到b，每次调用需要把自己挂起，第二次就来就是b了
        private tailrec suspend fun <P> transferInner(
                symCoroutine: SymCoroutine<P>, value: Any?
        ): T {
            if (this@SymCoroutine.isMain) {
                return if (symCoroutine.isMain) {
                    value as T
                } else {
                    val parameter = symCoroutine.coroutine.resume(value as P)
                    //parameter.coroutine为b
                    transferInner(parameter.coroutine, parameter.value)
                }
            } else {
//                报错
//                this@SymCoroutine.coroutine.yield()
                this@SymCoroutine.coroutine.run {
                    return yield(Parameter(symCoroutine, value as P))
                }
            }
        }

        suspend fun <P> transfer(symCoroutine: SymCoroutine<P>, value: P): T {
            return transferInner(symCoroutine, value)
        }
    }

    class Parameter<T>(val coroutine: SymCoroutine<T>, val value: T)

    val isMain: Boolean
        get() = this == main

    private val body = SymCoroutineBody()

    //不允许对称协程执行完
    private val coroutine = Coroutine<T, Parameter<*>>(context = context) {
        Parameter(this@SymCoroutine, suspend {
            println("--------Parameter----------"+it)
            block(body, it)
            if (this@SymCoroutine.isMain) Unit else throw IllegalStateException(
                    "SymCoroutine cannot be dead.")
        }() as T)
    }

    override fun resumeWith(result: Result<T>) {
        throw IllegalStateException("SymCoroutine cannot be dead!")
    }

    suspend fun start(value: T) {
        coroutine.resume(value)
    }
}

object SymCoroutines {
    val coroutine0: SymCoroutine<Int> = SymCoroutine.create<Int>("coroutine0") { param: Int ->
        log("coroutine-0", param)
        var result = transfer(coroutine2, 0)
        log("coroutine-0 1", result)
        result = transfer(SymCoroutine.main, Unit)
        log("coroutine-0 1", result)
    }

    val coroutine1: SymCoroutine<Int> = SymCoroutine.create("coroutine1") { param: Int ->
        log("coroutine-1", param)
        val result = transfer(coroutine0, 1)
        log("coroutine-1 1", result)
    }

    val coroutine2: SymCoroutine<Int> = SymCoroutine.create("coroutine2") { param: Int ->
        log("coroutine-2", param)
        var result = transfer(coroutine1, 2)
        log("coroutine-2 1", result)
        result = transfer(coroutine0, 2)
        //改成1会崩溃
//        result = transfer(coroutine1, 2)
        log("coroutine-2 2", result)
    }
}

