package cn.kotliner.coroutine.sequence

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.createCoroutine

/**
 * Created by benny on 5/29/17.
 */
fun main(args: Array<String>) {
//    for (i in fibonacci) {  //遍历，调用Iterator的next方法，next方法把刚刚设置的值返回
//        println(i)
//        if (i > 100) break
//    }

//    val var2: Iterator<Int> = fibonacci2.iterator()
//    //里面是个死循环，如果没有返回值，会一直调用resume，从而走到下面的suspend方法，改变state，执行挂起操作,执行到yield后，会改变状态，var2.hasNext()
//    // 返回true
//    while (var2.hasNext()) {
//        val i: Int = (var2.next() as Number).toInt()
//        val var3 = false
//        println(i)
//        if (i > 30) {
//            break
//        }
//    }
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
//val fibonacci2 = buildSequenceMy() {
//
////    yield(1) //每次调用，把值赋值给nextValue,然后挂起
//    var cur = 1
//    var next = 1
//    println("-------只会调用一次-----")
////    我们只需要在while循环体中循环调用yield()来检查该job的取消状态，如果已经被取消，那么isCompleted值将会是true，yield函数就直接抛出CancellationException异常，从而完成取消的功能：
//    while (true) {
//        try {
//            println("yield前")
//            //yield，会阻塞住，调用者调用var2.hasNext()
//            yield(next) //类似 我要开始耗时操作了方法
//            println("yield后")
//        } catch (e: Exception) {
//            log("Exception")
//        }
//        val tmp = cur + next
//        println("tmp= $tmp  cur=$cur next=$next")
//        cur = next
//        next = tmp
//    }
//
//
//}

public fun <T> buildSequenceMy(
    builderAction: suspend SequenceBuilder<T>.() -> Unit
): Sequence<T> = Sequence {
    buildIterator(builderAction)
}

fun <T> buildIterator(builderAction: suspend SequenceBuilder<T>.() -> Unit): Iterator<T> {
    val iterator = SequenceBuilderIterator<T>()
    iterator.nextStep =
        builderAction.createCoroutine(receiver = iterator, completion = iterator)
    return iterator
}