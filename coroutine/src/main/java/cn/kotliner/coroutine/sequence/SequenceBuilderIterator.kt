package cn.kotliner.coroutine.sequence

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class SequenceBuilderIterator<T> : SequenceBuilder<T>(), Iterator<T>, Continuation<Unit> {
    private var state: Int = 0
    private var nextValue: T? = null
    private var nextIterator: Iterator<T>? = null
    var nextStep: Continuation<Unit>? = null
    private val State_NotReady: Int = 0
    private val State_ManyNotReady: Int = 1
    private val State_ManyReady: Int = 2
    private val State_Ready: Int = 3
    private val State_Done: Int = 4
    private val State_Failed: Int = 5
    override fun hasNext(): Boolean {
        println("进入hasNext 此时state=" + getStatString())
        while (true) {
            when (state) {
                State_NotReady -> {
                }
                State_ManyNotReady ->
                    if (nextIterator!!.hasNext()) {
                        state = State_ManyReady
                        println("hasNext  State_ManyReady 返回false")
                        return true
                    } else {
                        nextIterator = null
                    }
                State_Done -> {
                    println("hasNext State_Done返回false")
                    return false
                }
                State_Ready, State_ManyReady -> {
                    println("hasNext State_Ready,State_ManyReady返回true")
                    return true
                }
                else -> throw exceptionalState()
            }
            println("循环hasNext 此时state=" + getStatString())
            state = State_Failed
            val step = nextStep!!
            nextStep = null
            step.resume(Unit)
        }
    }

    private fun getStatString(): String? {
        when (state) {
            State_NotReady -> return "State_NotReady"
            State_ManyNotReady -> return "State_ManyNotReady"
            State_ManyReady -> return "State_ManyReady"
            State_NotReady -> return "State_NotReady"
            State_Done -> return "State_Done"
            State_Failed -> return "State_NotReady"
        }
        return null
    }

    override fun next(): T {
        println("进入next")
        when (state) {
            State_NotReady, State_ManyNotReady -> {
                println("准备调用nextNotReady方法")
                return nextNotReady()
            }
            State_ManyReady -> {
                state = State_ManyNotReady
                println("next 里改State_ManyReady-》State_ManyNotReady")
                return nextIterator!!.next()
            }
            State_Ready -> {
                state = State_NotReady
                println("next 里改State_Ready-》State_NotReady")
                @Suppress("UNCHECKED_CAST")
                val result = nextValue as T
                nextValue = null
                return result
            }
            else -> throw exceptionalState()
        }
    }

    private fun nextNotReady(): T {
        if (!hasNext()) throw NoSuchElementException() else return next()
    }

    private fun exceptionalState(): Throwable = when (state) {
        State_Done -> NoSuchElementException()
        State_Failed -> IllegalStateException("Iterator has failed.")
        else -> IllegalStateException("Unexpected state of the iterator: $state")
    }

    suspend override fun yield(value: T) {
        println("yield")
        nextValue = value
        state = State_Ready
        return suspendCoroutine { c ->
            nextStep = c
        }
    }

    suspend override fun yieldAll(iterator: Iterator<T>) {
        if (!iterator.hasNext()) return
        nextIterator = iterator
        state = State_ManyReady
        return suspendCoroutine { c ->
            nextStep = c
        }
    }

    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Unit>) {
        if (result.isFailure) {

        } else {
            state = State_Done
        }

        TODO("Not yet implemented")
    }
}