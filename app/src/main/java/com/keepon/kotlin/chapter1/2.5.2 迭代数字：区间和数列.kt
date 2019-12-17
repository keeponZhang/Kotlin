package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//在Java当中，对于循环的处理方式为：先初始化变量，在循环的每一步更新它的值，并在值满足某个限制条件时退出循环。
//而在Kotlin中，为了替代常见的循环用法，使用了 区间 的概念，其本质上就是两个值之间的间隔，
//这两个值通常是数字：一个起始值，一个结束值。使用..运算符来表示区间，而结束值始终是区间的一部分。
fun forFun(startValue: Int, endValue: Int) {
    for (i in startValue..endValue) {
        println("Num = $i")
    }
}

//除此之外，还有downTo、step和until等用于区间的语法，用于进行循环操作，例如下面的例子downTo用于递减到指定的值，而step则指定步长：
fun forFunUp(startValue: Int, endValue: Int) {
    for (i in startValue..endValue step 2) {
        println("up Num = $i")
    }
}

//downTo用于递减到指定的值
fun forFunDown(startValue: Int, endValue: Int) {
    for (i in endValue downTo startValue step 2) {
        println("down Num = $i")
    }
}

//使用until则可以使迭代不包含指定的结束值，例如下面这样：
fun forFunUntil(startValue: Int, endValue: Int) {
    for (i in startValue until endValue) {
        println("until Num = $i")
    }
}

fun main(args: Array<String>) {
//    forFun(1,5)
//    forFunUp(1,10)
    forFunDown(1,10)
//    forFunUntil(1, 5)
}












