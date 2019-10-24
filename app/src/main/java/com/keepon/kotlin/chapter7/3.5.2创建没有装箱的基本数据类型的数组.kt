package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */

//数组类型的类型参数始终会变成对象类型，因此，如果你声明了一个Array<Int>，它将会是一个包含装箱整型的数组，如果你需要创建没有装箱的基本数据类型的数组，必须使用一个基本数据类型数组的特殊类。
//
//Kotlin提供了若干个独立的类，每一种基本数据类型对应一个，例如Int类型值的数组叫作IntArray，要创建一个基本数据类型的数组，有如下的选择：
//
//该类型的构造方法接收size参数并返回一个使用对应基本数据类型默认值初始化好的数组。
//工厂函数（例如IntArray的intArrayOf，以及其他数组类型的函数）接收变长参数的值并创建和存储这些值的数组。
//另一种构造方法，接收一个大小和一个用来初始化每个元素的lambda。
fun main(args: Array<String>) {
    //第一种创建方式
    val firstArray = IntArray(3)
    println(firstArray.joinToString(","))

    //第二种创建方式，必须要显示的指定元素的类型
    val secondArray = intArrayOf(1,2,3)
    println(secondArray.joinToString(","))

    //第三种创建方式
    val thirdArray =IntArray(3){
        i-> (i+1)*(i+1)
    }
    println(thirdArray.joinToString(","))

//    0,0,0
//    1,2,3
//    1,4,9

}

