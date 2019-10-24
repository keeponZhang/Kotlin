package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */

//+和-运算符总是返回一个新的集合
//+=和-=运算符用于可变集合时，始终在一个地方修改它们；而它们用于只读集合时，会返回一个修改过的副本。
//作为它们的运算数，可以使用单个元素，也可以使用元素类型一致的其它集合：

fun main(args: Array<String>) {
    val list = arrayListOf(1,2)
    list+=3
    val newlist = list +listOf(4,5)
    println(list)
    println(newlist)
}





















