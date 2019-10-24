package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */
//Kotlin没有为标准数字类型Int，Long等定义任何位运算符，因此也不允许你为自定类型定义它们。
//相反，它使用中缀调用语法的函数，可以为自定义类型定义相似的函数，下面我们为Point添加一个and，用于执行位运算。


infix  fun  Point.and(other:Point)= Point(x and other.x,y and other.y)
fun main(args: Array<String>) {
    val first :Point= Point(1,1)
    val second:Point = Point(3,3)
    println(first and second)
}

//这里我们不再使用operator关键字来声明，而是用infix来定义一个中缀调用语法的函数，其它执行位运算的函数包括：shl、shr、ushr、and、or、xor和inv。