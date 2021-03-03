package com.keepon.kotlin.chapter11

inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun main(args: Array<String>) {
    val num1 = 100
    val num2 = 200
    val result = num1AndNum2(num1, num2) { n1, n2 -> n1 + n2 }
}
















































