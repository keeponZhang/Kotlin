package cn.kotliner.coroutine.ui.operatorSample

import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

internal class CombinedContext(val left: CoroutineContext, val element: CoroutineContext.Element) : CoroutineContext {
    var name: String = ""
    override fun <E : CoroutineContext.Element> get(key: CoroutineContext.Key<E>): E? {
        var cur = this
        while (true) {
            cur.element[key]?.let { return it }
            val next = cur.left
            if (next is CombinedContext) {
                cur = next
            } else {
                return next[key]
            }
        }
    }

    public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R {
        println("1fold name=$name---- ${(left as? CombinedContext)?.name} ")
        //到最左边的是，Combined1 left的时候会调用下operation
        val leftFoldResult = left.fold(initial, operation)
        val result = operation(leftFoldResult, element)
        println("3fold name=$name ")
        return result
    }


    // Element:
    // public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R =
    //     operation(initial, this)

    public override fun minusKey(key: CoroutineContext.Key<*>): CoroutineContext {
        element[key]?.let { return left }
        val newLeft = left.minusKey(key)
        return when {
            newLeft === left -> this
            newLeft === EmptyCoroutineContext -> element
            else -> CombinedContext(newLeft, element)
        }
    }

    private fun size(): Int =
        if (left is CombinedContext) left.size() + 1 else 2

    private fun contains(element: CoroutineContext.Element): Boolean =
        get(element.key) == element

    private fun containsAll(context: CombinedContext): Boolean {
        var cur = context
        while (true) {
            if (!contains(cur.element)) return false
            val next = cur.left
            if (next is CombinedContext) {
                cur = next
            } else {
                return contains(next as CoroutineContext.Element)
            }
        }
    }

    override fun equals(other: Any?): Boolean =
        this === other || other is CombinedContext && other.size() == size() && other.containsAll(this)

    override fun hashCode(): Int = left.hashCode() + element.hashCode()

    override fun toString(): String =
        "[" + fold("") { acc, element ->
            println("2回调 name=$name acc=$acc")
            if (acc.isEmpty()) element.toString() else acc + ", " + element
        } + "]"
}