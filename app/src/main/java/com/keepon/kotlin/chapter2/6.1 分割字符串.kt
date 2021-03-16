package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */

//在Java中，我们会使用split来分割字符串，它接受一个正则表达式作为参数。
// 但是当我们想分割"."时，会得到一个空的数组，因为.号表示任何字符的正则表达式。
//而在kotlin中，它提供了一个接受Regex类型的重载函数，这样确保了当有一个字符串传递给这些函数的时候，
// 不会被当做正则表达式，我们可以使用扩展函数toRegex将字符串转换为正则表达式。

fun main(args: Array<String>) {
//    println("12.234-5.A".split("\\.|-".toRegex()))
    println("12.234-5.A".split("."))
}