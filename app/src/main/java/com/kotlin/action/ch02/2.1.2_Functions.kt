package ch02.ex1_2_Functions

//if是有结果值的表达式
//在Kotlin中，if是表达式，而不是语句。语句和表达式的区别在于，表达
//式有值，并且能作为另一个表达式的一部分使用；而语句总是包围着它的代码
//块中的顶层元素，并且没有自己的值。
//在Java中，所有的控制结构都是语句。而在Kotlin中，除了循环（for, do 和do/while）以外大多数控制结构都是表达式。

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

//表达式函数体
fun max1(a: Int, b: Int): Int = if (a > b) a else b

//因为只有一行可以这样省略
fun main(args: Array<String>) =
    println(max(1, 2))

