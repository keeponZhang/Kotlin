package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */
//下面我们讨论如何实现一个高阶函数，这个例子会尽量简单并且使用之前的lambda sum同样的声明，这个函数实现对于两个整数的任意操作，然后打印出结果：

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun main(args: Array<String>) {
//    twoAndThree { a, b -> a + b }
//    twoAndThree { a, b -> a * b }
    println("ab1c".filter { it in 'a'..'z' })
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}






























































