package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */

//重载一元运算的过程和前面看到的方式相同：用预先定义的一个名称来声明函数，并用修饰符operator标记。下面的例子中重载了-a运算符：
data class Point2(val x:Int ,val y:Int){
    operator fun unaryMinus() = Point(-x, -y)
}

fun main(args: Array<String>) {
    println(-Point2(1,2))
}

//所有可重载的一元算法运算符包括：
//+a：unaryPlus
//-a：unaryMinus
//!a：not
//++a/a++：inc
//--a/a--：dec

//当你定义inc和dec函数来重载自增和自减的运算符时，编译器自动支持与普通数字类型的前缀、后缀自增运算符相同的语义。例如后缀运算会先返回变量的值，然后才执行++操作