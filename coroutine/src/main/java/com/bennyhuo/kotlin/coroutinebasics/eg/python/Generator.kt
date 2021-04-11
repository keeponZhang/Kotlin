package com.bennyhuo.kotlin.coroutinebasics.eg.python

import android.util.Log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

interface Generator<T> {
    operator fun iterator(): Iterator<T>
}
//T就是传进来的
class GeneratorImpl<T>(
        private val block: suspend GeneratorScope<T>.(T) -> Unit, private val parameter: T
) : Generator<T> {
    override fun iterator(): Iterator<T> {
        return GeneratorIterator(block, parameter)
    }
}

sealed class State {
    class NotReady(val continuation: Continuation<Unit>) : State()
    class Ready<T>(val continuation: Continuation<Unit>, val nextValue: T) : State()
    object Done : State()
}
//Continuation调用调用resume
class GeneratorIterator<T>(
        private val block: suspend GeneratorScope<T>.(T) -> Unit, override val parameter: T
) : GeneratorScope<T>(), Iterator<T>, Continuation<Any?> {
    override val context: CoroutineContext = EmptyCoroutineContext

    private var state: State

    init {
        //没有参数的lambda表达式
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit = { block(parameter) }
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)
    }

    //改变state，并保存value（yield是挂起函数，继续的话需要调用resume，这里只是改变了状态，到hasNext的时候会调用resume）
    override suspend fun yield(value: T) = suspendCoroutine<Unit> { continuation ->
        state = when (state) {
            is State.NotReady -> State.Ready(continuation, value)
            is State.Ready<*> -> throw IllegalStateException("Cannot yield a value while ready.")
            State.Done -> throw IllegalStateException("Cannot yield a value while done.")
        }
    }

    private fun resume() {
        when (val currentState = state) {
            //resume会调用resumeWith，重新改变状态
            is State.NotReady -> currentState.continuation.resume(Unit)
        }
    }

    override fun hasNext(): Boolean {
        //resume是赋值，会调用到yield
        resume()
        return state != State.Done
    }

    override fun next(): T {
        return when (val currentState = state) {
            is State.NotReady -> {
                resume()
                return next()
            }
            is State.Ready<*> -> {
                //重新置为State.NotReady
                state = State.NotReady(currentState.continuation)
                (currentState as State.Ready<T>).nextValue
            }
            State.Done -> throw IndexOutOfBoundsException("No value left.")
        }
    }

    override fun resumeWith(result: Result<Any?>) {
        state = State.Done
        result.getOrThrow()
    }
}

abstract class GeneratorScope<T> internal constructor() {
    protected abstract val parameter: T

    abstract suspend fun yield(value: T)
}

fun <T> generator(block: suspend GeneratorScope<T>.(T) -> Unit): (T) -> Generator<T> {
    //要搞清楚parameter怎么来的,其实就是传进来的
    return { parameter: T ->
        GeneratorImpl(block, parameter)
    }
}

