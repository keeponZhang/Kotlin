package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */

//对于 表达式体函数，可以省略返回类型，因为编译器会分析作为函数体的表达式，并把它的类型作为函数的返回类型，这种分析称为 类型推导。但是对于有返回值的 代码块体函数，必须显示地写出返回类型和return语句。

fun max4(a:Int ,b:Int) = if(a>b) a else b

//有代码体的函数不写返回值类型表明返回值是Unit行
fun max5(a:Int ,b:Int){
}
fun max6(a:Int ,b:Int){
    return ;
}

//这个会报错
//fun max7(a:Int ,b:Int){
//    return 4 ;
//}


