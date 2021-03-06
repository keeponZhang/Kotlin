package com.keepon.kotlin.chapter2

import com.keepon.kotlin.chapter1.Rectangle

/**
 * createBy	 keepon
 */
//在kotlin中，创建HashSet、ArrayList和HashMap的方法如下：
//HashSet
val set = hashSetOf(1, 7, 8)

//ArrayList
val list = arrayListOf(1, 11, 22, 3)
val list2 = listOf(1, 11, 22, 3)

//hashMap
val map = hashMapOf<Int, String>(1 to "one", 44 to "yellow")


fun main(args: Array<String>) {
    println(set.javaClass)
    println(list.javaClass)
    println(list2.javaClass)
    println(map.javaClass)
    val rectangle = Rectangle(10, 10)
//    在这些集合对象上，我们除了可以使用Java当中定义的基本函数以外，还可以使用kotlin提供的扩展方法，例如下面的last和max
    //java中的标准方法
    println("list.get(0) ${list.get(0)}")
    //kotlin中的拓展方法
    println("list.last() ${list.last()}")
    //kotlin中的拓展方法
    println("list.max() ${list.max()}")
//    list.add(18)
//    list2.add(18)
}

//通过打印这些集合的类型，可以看到是采用的标准的Java集合类：
//class java.util.HashSet
//class java.util.ArrayList
//class java.util.HashMap

//这么做的原因，是因为使用标准的Java集合使kotlin可以更容易地与Java代码交互。当从Kotlin调用Java函数的时候，不用转换它的集合类来匹配Java的类，反之亦然。











