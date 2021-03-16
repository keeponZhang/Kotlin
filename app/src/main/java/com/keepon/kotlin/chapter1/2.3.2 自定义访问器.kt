package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//假设声明一个矩形，它能判断自己是否是正方形，那么就不需要一个单独的字段来存储这个信息，此时我们可以写一个自定义的访问器：用val开头作为声明，紧跟着的是属性的名称和类型，接下来是get()关键字，最后是一个函数体。

internal class Rectangle(var height: Int, var width: Int) {
    //这里用var修饰会报错

    //暴露为没有访问器的共有属性
    @JvmField()
    var isSquare: Boolean = true

    //    get() = 函数体 ,属性前面不用修饰private，修饰后自定义的访问器也是private，如果定义了访问器，不会自动生成set.get方法
    var isSquare2: Boolean = true
        set(iq: Boolean) {
            field = !iq
        }
        get() = height == 1
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(10, 10)
    rectangle.isSquare = false
    println("rectangle is ${rectangle.isSquare}")
    rectangle.width = 11
    println("rectangle is ${rectangle.isSquare}")
}






