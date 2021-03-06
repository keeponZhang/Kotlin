package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */

//在前面的例子中，if是表达式，而不是语句，表达式和语句的区别在于：
//表达式 有值，并且能作为另一个表达式的一部分使用。
//语句 总是包含着它的代码块中的顶层元素，并且没有自己的值。

//在Java中，所有的控制结构都是语句，而在Kotlin中，除了for、do和do/while以外大多数控制结构都是表达式。

//当函数体是由单个表达式构成时，可以用这个表达式作为完整的函数体，并且去掉花括号和return语句，上面的例子就是这种情况，因此可以改写为：
fun max2(a: Int, b: Int): Int = if (a > b) a else b
fun max3(a: Int, b: Int): Int = 2


//如果函数体写在花括号中，我们说这个函数有 代码块体
//如果它直接返回了一个表达式，它就有 表达式体
fun main(args: Array<String>) {
    var a: Int = 10;
    var b: Int = 11;
    var c = b - a;
    var dd = if (a == b) a else b
    println(dd)
}

