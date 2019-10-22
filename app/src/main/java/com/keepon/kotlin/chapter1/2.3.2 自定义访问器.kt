package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//假设声明一个矩形，它能判断自己是否是正方形，那么就不需要一个单独的字段来存储这个信息，此时我们可以写一个自定义的访问器：用val开头作为声明，紧跟着的是属性的名称和类型，接下来是get()关键字，最后是一个函数体。
class Rectangle(val height:Int,var width:Int){
    //这里用var修饰会报错
    val  isSquare:Boolean
        //get() = 函数体
        get() = height==width

}

fun main(args: Array<String>) {
    val rectangle = Rectangle(10,10)
    println("rectangle is ${rectangle.isSquare}")
    rectangle.width = 11
    println("rectangle is ${rectangle.isSquare}")
}






