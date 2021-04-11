package com.bennyhuo.kotlin.advancedfunctions.highorderfuncs

fun main() {
//    test1()

    test2()
}

private fun test1() {
    cost {
        val fibonacciNext = fibonacci()
        for (i in 0..10) {
            //fibonacciNext()调用的是返回blcok的invoke方法
            println(fibonacciNext())
        }
    }
    var test = cost2 {
        val fibonacciNext = fibonacci()
        for (i in 0..10) {
            //fibonacciNext()调用的是返回blcok的invoke方法
            println(fibonacciNext())
        }
    }
}

//拓展属性不能被初始化
//var abstract Person.color: String

private fun test2() {
    // region +折叠
    val intArray = intArrayOf(1, 2, 3, 4, 5)
    intArray.forEach {
        if (it == 4) return@forEach
        println("forEach $it")
    }
    for (i in intArray) {
        if (i == 4) {
            continue
        }
        println("forin $i")
    }

//    intArray.forEach(::println)

//    intArray.forEach {
//        println("Hello $it")
//    }
    //endregion
}

//region +折叠
fun needsFunction(block: () -> Unit) {
    block()
}

fun returnsFunction(): () -> Long {
    return { System.currentTimeMillis() }
}
//endregion

inline fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("${System.currentTimeMillis() - start}ms")
}

fun cost2(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("${System.currentTimeMillis() - start}ms")
}

//返回的是一个lambda表达式
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    println("fibonacci init")
    //这里返回的是block，说明上面的只会被初始化一次
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}

//fun fibonacci2(): () -> Long {
//    var first = 0L
//    var second = 1L
//    println("fibonacci init")
//    //这里返回的是block，说明上面的只会被初始化一次
//    return first + 2
//}