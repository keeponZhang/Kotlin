package com.bennyhuo.kotlin.coroutinebasics.eg.lua

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

sealed class Status {
    class Created(val continuation: Continuation<Unit>) : Status()
    class Yielded<P>(val continuation: Continuation<P>) : Status()
    class Resumed<R>(val continuation: Continuation<R>) : Status()
    object Dead : Status()
}

class Coroutine<P, R>(
        var name: String = "默认",
        override val context: CoroutineContext = EmptyCoroutineContext,
        private val block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
) : Continuation<R> {

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
            println("CoroutineBody create")
        }

        var parameter: P? = null

        suspend fun yield(value: R): P = suspendCoroutine { continuation ->
            val previousStatus = status.getAndUpdate {
                when (it) {
                    is Status.Created -> throw IllegalStateException("Never started!")
                    is Status.Yielded<*> -> throw IllegalStateException("Already yielded!")
                    is Status.Resumed<*> -> Status.Yielded(continuation)
                    Status.Dead -> throw IllegalStateException("Already dead!")
                }
            }
            println("yield " + value + " " + name + " continuation=" + continuation + " (previousStatus" +
                    " as? Status.Resumed<R>)?.continuation?" + ((previousStatus as? Status.Resumed<R>)?.continuation))
            // producer.resume(Unit)(注意，这个是生产一个消费一个，所以没有continuation)
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
        println("resumeWith-- " + this + " status=" + status)
        val previousStatus = status.getAndUpdate {
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
        (previousStatus as? Status.Resumed<R>)?.continuation?.resumeWith(result)
    }

    //这个resume跟continuation的resume不是一个概念
    suspend fun resume(value: P): R = suspendCoroutine { continuation ->

        val previousStatus = status.getAndUpdate {
            println("------" + name)
            when (it) {
                is Status.Created -> {
                    body.parameter = value
                    Status.Resumed(continuation)
                }
                is Status.Yielded<*> -> {
                    Status.Resumed(continuation)
                }
                is Status.Resumed<*> -> throw IllegalStateException("Already resumed!")
                Status.Dead -> throw IllegalStateException("Already dead!")
            }
        }
        println("resume " + value + " previousStatus=" + previousStatus + " name=" + name)
        when (previousStatus) {
            //会执行 block(parameter!!)
            is Status.Created -> previousStatus.continuation.resume(Unit)
            is Status.Yielded<*> -> (previousStatus as Status.Yielded<P>).continuation.resume(value)
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

