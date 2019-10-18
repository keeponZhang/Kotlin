package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//在Kotlin中，变量的声明以关键字val/var开始，然后是变量名称，最后可以加上类型（不加也可以），这里分为两种情况：

fun valFun(){
    val dValue = 1e6;
    val iValue = 6
    println("dValue=$dValue,iValue=$iValue")
}
//如果没有指定初始化器，需要显示地指定它的类型，因为此时编译器无法推断出它的类型。
fun valFun2(){
    val dValue:Int;
    val iValue = 6
    //没有初始化不能用，下面这条会报错
//    println("dValue=$dValue,iValue=$iValue")
    println("iValue=$iValue")
}

fun main(args: Array<String>) {
    val list = valFun()
}












