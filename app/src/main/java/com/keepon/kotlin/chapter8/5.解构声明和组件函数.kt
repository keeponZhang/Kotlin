package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */
//解构声明的功能允许你展开单个复合值，并使用它来初始化多个单独的变量。它再次用到了约定的原理，要在解构声明中初始化每个变量，将调用名为componentN的函数，其中N是声明中变量的位置。

//对于数据类，编译器为每个在主构造方法中声明的属性生成一个componentN函数，下面的例子显示了如何手动为非数据类声明这些功能：

class  Point5(val x:Int,val y:Int){
   operator fun component1() = x
   operator fun component2() = y
   operator fun component3() = y
}



//解构声明主要使用场景之一，是从一个函数返回多个值，这个非常有用。如果要这样做，可以定义一个数据类来保存返回所需的值，
//并将它作为函数的返回类型。在调用函数之后，可以用解构声明的方式，来轻松的展开它，使用其中的值。
//
//解构声明不仅可以用作函数中的顶层语句，还可以用在其他可以声明变量的地方，例如使用in循环来枚举map中的条目：

fun printEntries(map:Map<String,String>){
    for((key,value) in map){
        println("$key -> $value")
    }
}



fun main(args: Array<String>) {
    val p = Point5(10,20)
    val(x,y,z) = p
    println(x)
    println(y)

    val map = mapOf("Oracle" to "Java","Jetbrains" to "Kotlin")
    printEntries(map)
}


























