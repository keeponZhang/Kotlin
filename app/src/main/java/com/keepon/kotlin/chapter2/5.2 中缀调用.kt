package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//中缀调用 不是特殊的内置结构，而是一种特殊的函数调用。在中缀调用中，没有添加额外的分隔符，函数名称是直接放在目标对象名称和参数之间。例如我们声明了一个to函数。

//一般函数调用。
//1.to("One")
//中缀调用。
//1 to "One"

class Person(val name:String,val isMarrayied:Any){
    fun testDiff3(){
        println("testDiff3")
    }
}
infix  fun String.create(isMarried:Any) = Person(this,isMarried)
fun main(args: Array<String>) {
    val married:Person = "keepon" create true
    println("Name = ${married.name} ,isMarried = ${married.isMarrayied}")
}











