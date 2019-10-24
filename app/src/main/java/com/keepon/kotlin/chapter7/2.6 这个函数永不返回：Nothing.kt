package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */
//对于某些Kotlin函数来说，“返回类型”的概念没有任何意义，因为它们从来不会成功地结束，Kotlin使用一种特殊的返回类型Nothing来表示：
//Nothing类型没有任何值，只有被当作函数返回值使用，或者被当作泛型函数返回值的类型参数使用才会有意义，在其它情况下，声明一个不能存储任何值的变量没有任何意义。
fun  fail(message:String):Nothing{
    throw  IllegalStateException(message)
}
//返回Nothing的函数可以放在Elvis运算符的右边来做先决条件检查：

class Company(val address:String?)
fun main(args: Array<String>) {
//    fail("Error occurred")
    val company = Company(null)
    val address = company.address?: fail("No address")
    println(address)
}








