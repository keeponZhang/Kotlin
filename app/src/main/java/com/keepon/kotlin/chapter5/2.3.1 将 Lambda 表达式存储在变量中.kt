package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */


//匿名函数
var mutiplus = fun( value1:Int,value2:Int):Int{
    return value1 * value2
}

fun main(args: Array<String>) {
    // 2.3.1 将 Lambda 表达式存储在变量中
    val sum = {x:Int ,y:Int -> x+y}
    //跟匿名函数很像
    println("mutiplus="+ mutiplus(1,2))
    println("sum="+ sum(1,2))

//    2.3.2 直接调用 Lambda 表达式
//    如果需要把一小段代码封闭在一个代码块中，可以使用库函数run，这种调用和内建语言结构一样高效且不会带来额外运行时开销：
    run{
        println("I am run")
    }
}












