package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//例如集合当中slice函数的定义：
//fun <T> List<T>.slice(indices : IntRange) : List<T>

//接收者和返回类型都用到了函数的类型形参T，它们的类型都是List<T>，当在一个具体的列表上调用这个函数时，可以显示地指定类型实参，也可以让编译器自动推导出类型：


fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    //显示地指定类型实参。
    println(letters.slice<Char>(0..2))
    //编译器自动推导出T的类型是Char。
    println(letters.slice(10..13))
}
































