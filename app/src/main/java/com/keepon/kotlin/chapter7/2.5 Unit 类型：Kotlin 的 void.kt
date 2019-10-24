package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */


//Kotlin中的Unit类型完成了Java中的void一样的功能，当函数没有有意思的结果要返回时，它可以用作函数的返回类型：
//fun f() : Unit { .. }
//
//Unit是一个完备的类型，可以作为类型参数，而void却不行。只存在一个值是Unit类型，这个值也叫做Unit，
//并且（在函数中）会被隐式地返回，当你在重写返回泛型参数的函数时这非常有用，只需要让方法返回Unit类型的值：

interface  Processor<T>{
    fun  f():T
}
//Unit是一个完备的类型，可以作为类型参数
class NoResultProcessor:Processor<Unit>{
    override fun f() {
        println("I have no result")
    }
}

fun main(args: Array<String>) {
    val p = NoResultProcessor()
    p.f()
}



















