package cn.kotliner.coroutine.ui.operatorSample

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers

/**
 * Time:2023-05-08 上午 12:03
 * Author:
 * Description:
 */
fun main() {
    // test1()
    test2()
}

fun test2() {
    val combinedContext1 = CombinedContext(
        CoroutineName(
            "Combined1 left"
        ), CoroutineName(
            "Combined1 element"
        )
    )
    val combinedContext2 = CombinedContext(
        combinedContext1, CoroutineName(
            "Combined2 element"
        )
    )

    // combinedContext2.fold("") { acc, element ->
    //     println("acc=" + acc + " element=" + element)
    //     acc
    // }
    // println("xiaozhan combinedContext2 $combinedContext2")

    val combinedContext3 = CombinedContext(
        combinedContext2, CoroutineName(
            "Combined3element"
        )
    )
    println("xiaozhan combinedContext3 $combinedContext3")
}

fun test1() {
    val case1 = Dispatchers.IO
    println("xiaozhan case1 $case1")
}
