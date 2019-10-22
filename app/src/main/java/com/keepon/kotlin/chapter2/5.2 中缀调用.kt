package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//中缀调用 不是特殊的内置结构，而是一种特殊的函数调用。在中缀调用中，没有添加额外的分隔符，函数名称是直接放在目标对象名称和参数之间。
// 例如我们声明了一个to函数。
//中缀调用可以与 只有一个参数的函数 一起使用，无论是普通的函数还是扩展函数，要允许使用中缀符号调用函数，需要使用infix修饰符来标记它

//一般函数调用。
//1.to("One")
//中缀调用。
//1 to "One"

class Person(val name:String,val isMarrayied:Any){
    fun testDiff3(){
        println("testDiff3")
    }
}
//这里创建了一个String类型的中缀函数，表示调用者是String类型
//这里的中缀函数调用生成了一个Person类型的对象
infix  fun String.create(isMarried:Any) = Person(this,isMarried)
fun main(args: Array<String>) {
    val married:Person = "keepon" create true
    println("Name = ${married.name} ,isMarried = ${married.isMarrayied}")

    println(1 to "One")
    //(1, One)
}











