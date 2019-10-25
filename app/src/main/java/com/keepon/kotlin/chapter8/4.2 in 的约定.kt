package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */
//集合支持的另一个运算符是in运算符，用于检查某个对象是否属于集合，相应的函数叫做contains，下面的例子用于判断某个点是否处于矩形范围之内：

data class Rectangle(val upperLeft:Point,val lowerRight:Point)

operator fun Rectangle.contains(p:Point):Boolean{
    return  p.x in upperLeft.x until lowerRight.x
            && p.y in upperLeft.y until lowerRight.y
}

fun main(args: Array<String>) {
    val rect = Rectangle(Point(10,20), Point(50,50))
    println(Point(20,30) in  rect)
    println(Point(5,5) in  rect)

}