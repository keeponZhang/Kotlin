package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */

//Kotlin的可见性修饰符包括以下四种：
//修饰符	类成员	         顶层声明
//public	所有地方可见	 所有地方可见
//internal	模块中可见	     模块中可见
//protected	子类中可见	     ---
//private	类中可见	     文件中可见

//Java和Kotlin在可见性上的区别包括以下几点：
//在Java中默认的可见性是包私有的，而在Kotlin中，默认的可见性是public的。Kotlin用internal作为包可见的替代方案，它表示“只在模块内部可见”。
//Kotlin允许在顶层声明中使用private可见性，包括类、函数和属性，这些声明就只在声明它们的文件中可见，这是隐藏子系统实现细节的非常有用的方式。
//类的扩展函数不能访问它的private和protected成员。
//Kotlin中，一个外部类不能看到其内部类中的private成员。