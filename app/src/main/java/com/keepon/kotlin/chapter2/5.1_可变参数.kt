package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//使用关键字 vararg，可以用来声明一个函数将有可能有任意数量的参数
fun varargFunc(vararg  ints:Int){
    println(ints.javaClass)
    for (int in ints) {
        println("var=${int}")
    }
}

fun main(args: Array<String>) {
    varargFunc(12,44,55)

//    如果我们已经将参数打包成一个数组，这时候如果想要将它传递给一个接收可变参数的函数，那么需要先通过*操作符进行解包
    val intArray = intArrayOf(1,2,3)
    varargFunc(*intArray)
}









