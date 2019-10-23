package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */
//除此之外，还可以引用顶层函数，这里我们省略了类名称，直接以:开头，成员引用::salute被当作实参传递给库函数run，它会调用相应的函数：

fun salate() = println("Salute")
fun salate2( name:String) {
    println("Salute2"+name)
}

fun main(args: Array<String>) {
//    salate()
    //lambda表达式与函数
    //这个是错误的
    run { ::salate }
    //::salate等于lambda表达式
    run (::salate)
//    run { ::salate2 }
}













