package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */

//lambda表达式可以包含更多的语句，最后一个表达式就是lambda的结果：

fun main(args: Array<String>) {
    val sum = {x:Int,y:Int ->
        println("start lala")
        x+y
    }
    println(sum(1,4))
}











