package com.bennyhuo.kotlin.coroutines.sample.yuanli

import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * createBy	 keepon
 */
internal class CombinedContextV2(
        private val left: CoroutineContextV2,
        private val element: ElementV2
) : CoroutineContextV2, java.io.Serializable {

    override fun <E : ElementV2> get(key: CoroutineContextV2.KeyV2<E>): E? {
        var cur = this
        while (true) {
            cur.element[key]?.let { return it }
            val next = cur.left
            if (next is CombinedContextV2) {
                cur = next
            } else {
                return next[key]
            }
        }
    }

    public override fun <R> fold(initial: R, operation: (R, ElementV2) -> R):
            R {
        //   context.fold(
//          this) { acc, element -> //我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element
        val fold = left.fold(initial, operation)
//        log("fold initial= $initial  fold=$fold")
        val operation1 = operation(fold, element)
        return operation1
    }

    override fun toString(): String =
            "[" + fold("") { acc, element ->
                if (acc.isEmpty()) {
//                    log("1CombinedContextV2.toString()----------  element=$element")
                    element.toString()
                } else {
//                    log("2CombinedContextV2.toString()---------- acc=$acc element=$element")
                    "$acc, $element"
                }
            } + "]"

    public override fun <R> fold2(initial: R, operation: (R, ElementV2) -> R):
            R {
//       left.fold2(initial, operation)可以看成  initial+left，即“‘+left，这个会触发operation的第一次调用
        //   context.fold( this) { acc, element -> //我们可以把acc理解成+号左边的CoroutineContext，element理解成+号右边的CoroutineContext的某一个element
//       这里一路向左，遍历，遍历到最左边肯定是个element，然后执行operation，走到下面acc.isEmpty()分支
        log("left.fold2  before-- left=$left element=$element")
        val fold = left.fold2(initial, operation)
//        operation(initial, this)=operation(initial, this)acc, element
        log("left.fold2 after-- 结果fold=$fold,接着的element=$element")
        val operation1 = operation(fold!!, element)
        return operation1
    }

    //其实相当于""+this
    override fun getString(): String {
        val fold2 = fold2("")
        { acc, element ->
            if (acc.isEmpty()) {
                log("1CombinedContextV2.getString()----------  element=$element")
                element.toString()
            } else {
                log("2CombinedContextV2.getString()---------- acc=$acc element=$element")
                "$acc, $element"
            }
        }
        log("-----fold2 $fold2-------")
        return "[ $fold2 ]"
    }


    //    //CombinedContext的minusKey操作的逻辑是：
//    //1、先看element是否是匹配，如果匹配，那么element就是需要删除的元素，返回left，否则说明要删除的元素在left中，继续从left中删除对应的元素，根据left是否删除了要删除的元素转到2或3或4
//    //2、如果left中不存在要删除的元素，那么当前CombinedContext就不存在要删除的元素，直接返回当前CombinedContext实例就行
//    //3、如果left中存在要删除的元素，删除了这个元素后，left变为了空，那么直接返回当前CombinedContext的element就行
//    //4、如果left中存在要删除的元素，删除了这个元素后，left不为空，那么组合一个新的CombinedContext返回
    public override fun minusKey(
            key: CoroutineContextV2.KeyV2<*>, elementV2: ElementV2
    ): CoroutineContextV2 {
//        log("开始 ${showName(key)} left = $left element=$element  右边被加的那个elementV2=$elementV2")
//        如果element要删除的，直接返回
        element[key]?.let {
//            log("删除的刚好是element")
            return left
        }
        val newLeft = left.minusKey(key, elementV2)
        return when {
            newLeft === left -> {
//                log("1 newLeft === left left中不存在要删除的元素,返回当前CombinedContext实例就行${showName(key)}")
                this
            }
            newLeft === EmptyCoroutineContextV2 -> {
//                log("2 newLeft === EmptyCoroutineContextV2 left中存在要删除的元素，删除了这个元素后，left变为了空," +
//                        "返回element作为做键 element=$element${showName(key)}")
                element
            }
            else -> {
                log("3 else left中存在要删除的元素，删除了这个元素后，left不为空，组合一个新的CombinedContext返回 ${showName
                (key)}")
                CombinedContextV2(newLeft, element)
            }
        }
    }

    private fun showName(key: CoroutineContextV2.KeyV2<*>? = null): String {
        return " this=${toString()}  "
    }

    private fun size(): Int {
        var cur = this
        var size = 2
        while (true) {
            cur = cur.left as? CombinedContextV2 ?: return size
            size++
        }
    }

    private fun contains(element: ElementV2): Boolean =
            get(element.key) == element

    private fun containsAll(context: CombinedContextV2): Boolean {
        var cur = context
        while (true) {
            if (!contains(cur.element)) return false
            val next = cur.left
            if (next is CombinedContextV2) {
                cur = next
            } else {
                return contains(next as ElementV2)
            }
        }
    }

    override fun equals(other: Any?): Boolean =
            this === other || other is CombinedContextV2 && other.size() == size() && other.containsAll(
                    this)

    override fun hashCode(): Int = left.hashCode() + element.hashCode()

    private fun writeReplace(): Any {
        val n = size()
        val elements = arrayOfNulls<CoroutineContextV2>(n)
        var index = 0
        fold(Unit) { _, element -> elements[index++] = element }
        check(index == n)
        @Suppress("UNCHECKED_CAST")
        return Serialized(elements as Array<CoroutineContextV2>)
    }

    private class Serialized(val elements: Array<CoroutineContextV2>) : java.io.Serializable {
        companion object {
            private const val serialVersionUID: Long = 0L
        }

        private fun readResolve(): Any =
                elements.fold(EmptyCoroutineContextV2, CoroutineContextV2::plus)
    }
}
