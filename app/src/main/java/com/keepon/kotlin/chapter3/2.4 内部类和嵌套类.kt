package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//在Kotlin中，如果我们像Java一样，在一个类的内部定义一个类，那么它并不是一个 内部类，而是 嵌套类，区别在于嵌套类不会持有外部类的引用，也就是说它实际上是一个静态内部类
class Outer{
    val name = "keepon"
    class Inner{

    }
//    如果要把它嵌套类变成一个 内部类 来持有一个外部类的引用的话需要使用inner修饰符，并且访问外部类时，需要使用this@{外部类名}的方式。
    inner  class  Inner2{
        fun getOuterShuxing(){
            this@Outer
        }

    }
}