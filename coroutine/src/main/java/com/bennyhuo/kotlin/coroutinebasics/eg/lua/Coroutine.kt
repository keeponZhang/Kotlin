package com.bennyhuo.kotlin.coroutinebasics.eg.lua

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import kotlinx.coroutines.yield
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

//有栈非对称协程 yield挂起，resume恢复
//有栈协程：可以在任意函数嵌套中挂起，例如Lua Coroutine
//无栈协程：只能在当前函数嵌套中挂起，例如Python Coroutine

//非对称协程，yield只能将调用权转移给对应的resume
sealed class Status {
    class Created(val continuation: Continuation<Unit>) : Status()
    class Yielded<P>(val continuation: Continuation<P>) : Status()
    class Resumed<R>(val continuation: Continuation<R>) : Status()
    object Dead : Status()
}

//类似ContinuationImpl的角色
//P是参数的类型，R是生产的类型
class Coroutine<P, R>(
        var name: String = "默认",
        override val context: CoroutineContext = EmptyCoroutineContext,
        private val block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
) : Continuation<R> {
    //    Coroutine<P, R>.CoroutineBody内部类，表示这个lambda表达式是定义在该类上
    companion object {
        fun <P, R> create(
                name: String = "默认",
                context: CoroutineContext = EmptyCoroutineContext,
                block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
        ): Coroutine<P, R> {
            return Coroutine(name, context, block)
        }
    }

    suspend fun test(): Unit {
        yield()
    }

    //希望yield在里面调用，所以用了CoroutineBody
    inner class CoroutineBody {
        init {
            log("CoroutineBody create")
        }

        var parameter: P? = null

        // yield为什么是传R，因为这里会通过yield生产值
//        只要看P,返回值是通过continuation
//        挂起点的continuation保存在Status，这里恢复的是上次挂起的位置，通过上次的状态
        suspend fun yield(value: R): P = suspendCoroutine<P> { continuation ->
            val previousStatus = status.getAndUpdate {
                when (it) {
                    is Status.Created -> throw IllegalStateException("Never started!")
                    is Status.Yielded<*> -> throw IllegalStateException("Already yielded!")
//                    保存了当前挂起点
                    is Status.Resumed<*> -> Status.Yielded(continuation)
                    Status.Dead -> throw IllegalStateException("Already dead!")
                }
            }
            log("yield $name " + value + " continuation=" + continuation + " " +
                    "(previousStatus" +
                    " as? Status.Resumed<R>)?.continuation?" + ((previousStatus as? Status.Resumed<R>)?.continuation))
            // producer.resume(Unit)(注意，这个是生产一个消费一个，所以没有continuation
//            把之前保存的continuation恢复，执行的
//            把生产的值传给resume
            (previousStatus as? Status.Resumed<R>)?.continuation?.resume(value)
        }
    }

    private val body = CoroutineBody()

    private val status: AtomicReference<Status>

    val isActive: Boolean
        get() = status.get() != Status.Dead

    init {
        //parameter不用传进来
        val coroutineBlock: suspend CoroutineBody.() -> R = { block(parameter!!) }
        val start = coroutineBlock.createCoroutine(body, this)
        status = AtomicReference(Status.Created(start))
    }

    override fun resumeWith(result: Result<R>) {
        log("resumeWith $name  status=" + status)
        val previousStatus = status.getAndUpdate {
            //it就是previousStatus
            when (it) {
                is Status.Created -> throw IllegalStateException("Never started!")
                is Status.Yielded<*> -> throw IllegalStateException("Already yielded!")
                is Status.Resumed<*> -> {
                    //给status赋值
                    Status.Dead
                }
                Status.Dead -> throw IllegalStateException("Already dead!")
            }
        }
//        Resumed的时候回调出去
        (previousStatus as? Status.Resumed<R>)?.continuation?.resumeWith(result)
    }

    //这个resume跟continuation的resume不是一个概念，
    suspend fun resume(value: P): R = suspendCoroutine { continuation ->
        val previousStatus = status.getAndUpdate {
            when (it) {
                is Status.Created -> {
                    body.parameter = value
//第一次状态改为Resumed，把continuation传进去
                    Status.Resumed(continuation)
                }
                is Status.Yielded<*> -> {
                    Status.Resumed(continuation)
                }
                is Status.Resumed<*> -> throw IllegalStateException("Already resumed!")
                Status.Dead -> throw IllegalStateException("Already dead!")
            }
        }
        log("resume $name " + value + " previousStatus=" + previousStatus)
        when (previousStatus) {
            //会执行 block(parameter!!)，协程第一次resume，不需要参数，这的resume不是该方法的resume，相当于调用ContinuationImpl
            // 的resume
            is Status.Created -> previousStatus.continuation.resume(Unit)
            is Status.Yielded<*> -> {
                log("resume-------- $name is Status.Yield")
                (previousStatus as Status.Yielded<P>).continuation.resume(value)
            }
        }
    }

    suspend fun <SymT> SymCoroutine<SymT>.yield(value: R): P {
        return body.yield(value)
    }
}

class Dispatcher : ContinuationInterceptor {
    override val key = ContinuationInterceptor

    private val executor = Executors.newSingleThreadExecutor()

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        return DispatcherContinuation(continuation, executor)
    }
}

class DispatcherContinuation<T>(val continuation: Continuation<T>, val executor: Executor) :
        Continuation<T> by continuation {

    override fun resumeWith(result: Result<T>) {
        executor.execute {
            continuation.resumeWith(result)
        }
    }
}

