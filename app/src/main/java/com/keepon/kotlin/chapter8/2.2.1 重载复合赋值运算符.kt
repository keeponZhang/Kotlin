package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */

//当在定义像plus这样的函数，Kotlin不止支持+号运算，也支持像+=这样的 复合赋值运算符
//fun main(args: Array<String>) {
//这里用var 时会报错
//    var first :Point= Point(1,1)
//    val second:Point = Point(3,3)
//    first+=second
////    first+second
//    println(first )
//}

fun main(args: Array<String>) {
    val first :Point= Point(1,1)
    val second:Point = Point(3,3)
    first+=second
    println(first )
}


//解决方法有两种：
//使用 不可变 val 代替可变 var 来修饰first，这样plus运算符就不再适用。
//不要同时为一个类添加plus和plusAssign运算。如果一个类是 不可变的，那就应该只提供返回一个新值的运算；如果一个类是 可变的，例如构建器，那么只需要提供plusAssign和类似的运算符就够了。
//













































