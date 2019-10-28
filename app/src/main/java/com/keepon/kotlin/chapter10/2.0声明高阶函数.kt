package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */

//按照定义，高阶函数就是 以另一个函数作为参数或者返回值的函数，在Kotlin中，函数可以用lambda或者函数引用来表示。
//例如，标准库中的filter函数将一个判断式函数作为参数，因此它就是一个高阶函数。

fun test1(): Unit {
    val list = listOf(1,2)
    list.filter {it -> 2 > 0 }
    val str = ""
    //拓展函数有个隐含的参数，就是调用者本身
    str.filter { 2 > 0  }
}
