package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */

//Kotlin和Java之间一条重要的区别就是处理数字转换的方式，Kotlin不会自动地把数字从一种类型转换成另一种，即便是转换成范围更大的类型，
//我们必须 显示地转换，对每一种基本数据类型都定义有转换函数：toByte()、toShort()、toChar()等，这些函数支持双向转换：
//fun main(args: Array<String>) {
//    val x  = 1
//    println(x.toLong() in listOf(1L,2L))
//}

//在比较装箱值的时候，比较两个装箱值的equals不仅会检查它们存储的值，还要比较装箱类型，也就是说new Integer(42).equals(new Long(42))会返回false。

//Kotlin除了支持简单的十进制数字之外，还支持下面这些在代码中书签数字字面值的方式：
//
//使用后缀L表示Long：123L
//使用标准浮点数表示Double：0.12、1.2e10和1.2e-10。
//使用后缀F表示Float：123.4f、.456F和1e3f。
//使用前缀0x或者0X表示十六进制：0xbcdL。
//使用前缀0b或者0B表示二进制字面值：0b0001。
//
//
//当你使用数字字面值去初始化一个类型已知的变量时，又或是把字面值作为实参传给函数时，必要的转换会自动地发生。


fun foo(l:Long) = println(l)

fun main(args: Array<String>) {
    val b:Byte = 1   //从int 到Byte
    val l = b+ 1L   //可以进行字节类型和长整型参数的计算
    foo(42)   //函数声明的是Long,会发生从int到Long的隐式转换
}





