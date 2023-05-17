package cn.kotliner.coroutine.ui.operatorSample

import cn.kotliner.coroutine.ui.operatorSample.custom.CoroutineName

/**
 * Time:2023-05-08 上午 12:03
 * Author:
 * Description:
 * https://blog.csdn.net/future234/article/details/121690474
 */
fun main() {
    test1()
    //test2()
    //test3()
}

fun test1() {
    val combinedContext1 = MyCombinedContext(
        CoroutineName(
            "Combined1 left"
        ), CoroutineName(
            "Combined1 element"
        )
    )
    combinedContext1.name = "name1"
    println("xiaozhan combinedContext1 $combinedContext1")
}

fun test2() {
    val combinedContext1 = MyCombinedContext(
        CoroutineName(
            "Combined1 left"
        ), CoroutineName(
            "Combined1 element"
        )
    )

    combinedContext1.name = "c1"
    val combinedContext2 = MyCombinedContext(
        combinedContext1, CoroutineName(
            "Combined2 element"
        )
    )
    combinedContext2.name = "c2"
    println("xiaozhan combinedContext2 $combinedContext2")

    // combinedContext2.fold("") { acc, element ->
    //     println("acc=" + acc + " element=" + element)
    //     acc
    // }
    // println("xiaozhan combinedContext2 $combinedContext2")

}

fun test3() {
    val combinedContext1 = MyCombinedContext(
        CoroutineName(
            "Combined1 left"
        ), CoroutineName(
            "Combined1 element"
        )
    )

    combinedContext1.name = "c1"
    val combinedContext2 = MyCombinedContext(
        combinedContext1, CoroutineName(
            "Combined2 element"
        )
    )
    combinedContext2.name = "c2"

    // combinedContext2.fold("") { acc, element ->
    //     println("acc=" + acc + " element=" + element)
    //     acc
    // }
    // println("xiaozhan combinedContext2 $combinedContext2")

    val combinedContext3 = MyCombinedContext(
        combinedContext2, CoroutineName(
            "Combined3element"
        )
    )
    combinedContext3.name = "c3"
    println("xiaozhan combinedContext3 $combinedContext3")
}


