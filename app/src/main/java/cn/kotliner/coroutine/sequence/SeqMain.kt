package cn.kotliner.coroutine.sequence

import cn.kotliner.coroutine.common.log
import kotlin.coroutines.experimental.SequenceBuilder
import kotlin.coroutines.experimental.buildSequence
import kotlin.coroutines.experimental.intrinsics.createCoroutineUnchecked

/**
 * Created by benny on 5/29/17.
 */
fun main(args: Array<String>) {
    for (i in fibonacci) {  //遍历，调用Iterator的next方法，next方法把刚刚设置的值返回
        println(i)
        if (i > 100) break
    }
}
//
//BuilderInference builderAction: suspend SequenceBuilder<T>.() -> Unit
//BuilderInference builderAction: suspend (SequenceBuilder) -> Unit
//val fibonacci = listOf(10,20)


//public fun <T> buildIterator(@BuilderInference builderAction: suspend SequenceBuilder<T>.() -> Unit): Iterator<T> {
//    val iterator = SequenceBuilderIterator<T>()
//    iterator.nextStep = builderAction.createCoroutineUnchecked(receiver = iterator, completion = iterator)
//    return iterator
//iterator.nextStep被赋值Coroutine
//}
val fibonacci = buildSequence() {
    yield(1) //每次调用，把值赋值给nextValue,然后挂起
    var cur = 1
    var next = 1

//    我们只需要在while循环体中循环调用yield()来检查该job的取消状态，如果已经被取消，那么isCompleted值将会是true，yield函数就直接抛出CancellationException异常，从而完成取消的功能：

    while (true) {
        try {
            yield(next) //类似 我要开始耗时操作了方法
        } catch (e: Exception) {
            log("Exception")
        }

        val tmp = cur + next
        cur = next
        next = tmp
    }
}