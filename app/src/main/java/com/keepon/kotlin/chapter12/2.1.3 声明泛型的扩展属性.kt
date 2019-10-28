package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//我们可以给 类或接口的方法、顶层函数、扩展函数和扩展属性 声明类型参数，在上面的例子中，类型参数用在了接收者和lambda参数上，下面我们再来看一个 声明泛型的扩展属性 的例子：

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).penultimate)
}




































