package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */
//在 Kotlin 知识梳理(2) - 函数的定义与调用 中，我们通过joinToString介绍了命名参数和默认参数值的用法，实际上在标准库中也有定义这个函数，不同之处在于它可以接收一个附加的函数参数，
//这个函数可以用toString函数以外的方法来把一个 元素转换成字符串，下面显示如何 只打印出人的名字


fun main(args: Array<String>) {
    val personlist = listOf<Person>(Person("alice",22), Person("keeon",22))
    val name = personlist.joinToString(transform={p:Person ->p.name })
    println(name)
}









































