package cn.kotliner.coroutine.ui.operatorSample.custom

import com.bennyhuo.kotlin.coroutines.utils.log


open class CombinedContext(
    val left: CoroutineContext,
    val element: CoroutineContext.Element,
    override var name: String = ""
) : CoroutineContext {
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


    //    //CombinedContext的minusKey操作的逻辑是：
//    //1、先看element是否是匹配，如果匹配，那么element就是需要删除的元素，返回left，否则说明要删除的元素在left中，继续从left中删除对应的元素，根据left是否删除了要删除的元素转到2或3或4
//    //2、如果left中不存在要删除的元素，那么当前CombinedContext就不存在要删除的元素，直接返回当前CombinedContext实例就行
//    //3、如果left中存在要删除的元素，删除了这个元素后，left变为了空，那么直接返回当前CombinedContext的element就行
//    //4、如果left中存在要删除的元素，删除了这个元素后，left不为空，那么组合一个新的CombinedContext返回
    public override fun minusKey(
        key: CoroutineContext.Key<*>
    ): CoroutineContext {
//        log("开始 ${showName(key)} left = $left element=$element  右边被加的那个elementV2=$elementV2")
//        如果element要删除的，直接返回
        element[key]?.let {
            log("删除的刚好是element $key")
            return left
        }
        val newLeft = left.minusKey(key)
        return when {
            newLeft === left -> {
                log("1 newLeft === left left中不存在要删除的元素,返回当前CombinedContext实例就行${showName(key)}")
                this
            }
            newLeft === EmptyCoroutineContext -> {
                log(
                    "2 newLeft === EmptyCoroutineContextV2 left中存在要删除的元素，删除了这个元素后，left变为了空," +
                        "返回element作为做键 element=$element${showName(key)}"
                )
                element
            }
            else -> {
                log(
                    "3 else left中存在要删除的元素，删除了这个元素后，left不为空，组合一个新的CombinedContext返回 ${
                        showName
                            (key)
                    }"
                )
                CombinedContext(newLeft, element)
            }
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


    // Element:
    // public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R =
    //     operation(initial, this)
    public override fun <R> fold(initial: R, operation: (R, CoroutineContext.Element) -> R): R {
        //到最左边的是，Combined1 left的时候会调用下operation,坐左边的left一定也是个element
        val leftFoldResult = left.fold(initial, operation)
        if (leftFoldResult is CoroutineContext) {
            println("1fold name=$name  leftFoldResult=${leftFoldResult.name}")
        }
        val result = operation(leftFoldResult, element)
        println("3fold name=$name ")
        return result
    }

    //element的fold，initial会透传，element传当前元素
    override fun toString(): String =
        "[" + fold("") { acc, element ->
            println("2回调 name=$name acc=${acc} element=${element.name}")
            if (acc.isEmpty()) element.toString() else acc + ", " + element
        } + "]"

    private fun showName(key: CoroutineContext.Key<*>? = null): String {
        return " this=${name}  "
    }
}