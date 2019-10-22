package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//when是一个有返回值的表达式，因此，作为表达式函数体，
// 它可以去掉花括号和return语句，并省略返回类型的声明。
fun getWarmth(color:Color) = when(color){
    Color.RED -> "warm"
    Color.ORANGE -> "warm2"
    Color.YELLOW -> "warm3"
    else -> "other"
}

fun main(args: Array<String>) {
    println(getWarmth(Color.ORANGE))
    println(getWarmth(Color.RED))
}