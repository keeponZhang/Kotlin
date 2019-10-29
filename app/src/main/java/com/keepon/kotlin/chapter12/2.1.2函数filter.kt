package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
var test = ""

//下面再来看filter的例子
//fun main(args: Array<String>) {
//    val authors = listOf("first", "second")
//    val readers = mutableListOf("first", "third")
//    println(readers.filter { it !in authors })
//}

//其中filter的定义为：
//fun <T> List<T>.filter(predicate : (T) -> Boolean) : List<T>

//在上面的例子中，自动生成的lambda参数it的类型为String。编译器推断T就是String，因为它知道函数是在List<T>上调用，
//而它的接收者readers的真实类型是List<String>。


















