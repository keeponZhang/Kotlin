package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */

//在平时的开发中，我们往往会使用许多的xxBean对象用作数据容器，而在定义这些对象时，一般会重写它的以下三个方法：
//equals：用来比较实例
//hashCode：用来作为例如HashMap这种基于哈希容器的类
//toString：用来为类生成按声明顺序排列的所有字段的字符串表达形式
//
//在Kotlin中，只需要为你的类添加data关键字，以上这些必要的方法就会自动生成好，例如下面的例子，我们演示了以上三个方法的作用
data class Client2(val name:String ,val postalCode:Int){
}

fun main(args: Array<String>) {
    val bob = Client2("keepon",211)

//    为了让使用不可变对象变得容易，Kotlin编译器为它们生成了copy方法，
//    并在copy的同时修改某些属性的值，copy出来的副本有着单独的声明周期而且不会影响代码中引用原始实例的位置，使用方法如下
    println(bob.copy(postalCode = 110))
}