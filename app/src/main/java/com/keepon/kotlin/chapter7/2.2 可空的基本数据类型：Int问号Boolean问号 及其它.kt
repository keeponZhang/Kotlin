package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */

//Kotlin中的可空类型不能用Java的基本数据类型表示，因为null只能被存储在Java的引用类型的变量中。
//任何时候，只要使用了基本数据类型的可空版本，它就会被编译成对应的包装类型，并且不能比较两个可空基本数据类型的大小，
//因为它们之中任何一个都可能为null。
//
//除此之外，泛型类是包装类型应用的另一种情况，如果你 用基本数据类型作为泛型类的类型参数，
//那么 Kotlin 会使用该类型的包装形式，例如下面这段代码，就会创建一个Integer包装类的列表，
//尽管你从来没有指定过可空类型或者用过null值：
//
//val listOfInts = listOf(1, 2, 3)
//
//这是由Java虚拟机实现泛型的方式决定的，JVM不支持用基本数据类型作为类型参数，所以泛型类必须始终使用类型的包装表示。
































