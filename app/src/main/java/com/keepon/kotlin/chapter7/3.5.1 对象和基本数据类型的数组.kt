package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */
//Kotlin中的一个数组是一个带有类型参数的类，其元素类型被指定为相应的类型参数，要在Kotlin中创建数组，有下面这些方法供你选择
//
//arrayOf函数创建一个数组，它包含的元素是指定为该函数的实参
//arrayOfNulls创建一个给定大小的数组，包含的是null元素，当然，它只能用来创建包含元素类型可空的数组
//Array构造方法接收数组的大小和一个lambda表达式，调用lambda表达式来创建每一个数组元素，这就是使用非空元素类型来初始化数组，但不用显示地传递每个元素的方式

fun main(args: Array<String>) {
    //第一种创建方式
    val firstArray = arrayOf(1,2,3)
    println(firstArray.joinToString(","))

    //第二种创建方式，必须要显示的指定元素的类型
    val secondArray = arrayOfNulls<Int>(3)
    secondArray[0] = null
    secondArray[1] = 2
    println(secondArray.joinToString(","))

    //第三种创建方式
    val thirdArray = Array<String>(26){
        i->('a'+i).toString()
    }
    println(thirdArray.joinToString(","))

}

























