package com.kotlin.action.ch02.book.语句和表达式.kt

/**
 *createBy keepon
 */

//语句和表达式
//在Kotlin 中， if 是表达式，而不是语句。语句和表达式的区别在于，表达
//式有值，并且能作为另一个表达式的一部分使用；而语句总是包围着它的代码
//块中的顶层元素，并且没有自己的值。在Java 中，所有的控制结构都是语句。
//而在Kotlin 中，除了循环（ for, do 和do/while ）以外大多数控制结构都是
//表达式。这种结合控制结构和其他表达式的能力让你可以简明扼要地表示许多
//常见的模式，稍后你会在本书中看到这些内容。
//另一方面， Java 中的赋值操作是表达式，在Kotlin 中反而变成了语句。这
//有助于避免比较和赋值之间的混淆，而这种混淆是常见的错误来源。