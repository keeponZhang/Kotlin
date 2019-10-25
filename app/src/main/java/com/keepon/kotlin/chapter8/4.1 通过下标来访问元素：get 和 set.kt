package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */
//在Kotlin中，下标运算符是一种约定，使用下标运算符读取元素会被转换为get运算符方法的调用，并且写入元素将调用set，下面我们为Point类添加类似的方法：
data class Point4(var x:Int,var y:Int){

}

operator fun Point4.get(index:Int):Int{
    return when(index){
        0 -> x
        1 -> y
        else -> throw  IndexOutOfBoundsException("Invalide coordinate $index")
    }
}

operator fun Point4.set(index:Int,value:Int){
    return when(index){
        0 -> x = value
        1 -> y= value
        else -> throw  IndexOutOfBoundsException("Invalide coordinate $index")
    }
}

fun main(args: Array<String>) {
    val p = Point4(10,33)
    p[1] = 44
    println(p[1])
}

//get的参数可以是任何类型，而不止是Int，例如，当你对map使用下标运算符时，参数类型是键的类型，它可以是任意类型。还可以定义具有多个参数的get方法，
//例如如果要实现一个类来表示二维数组或矩阵，你可以定义一个方法，例如operator fun get(rowIndex : Int, colIndex : Int)，然后用matrix[row, col]来调用。

