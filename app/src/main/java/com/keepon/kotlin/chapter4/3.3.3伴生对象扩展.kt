package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */

//在 Kotlin 知识梳理(2) - 函数的定义与调用 中，我们介绍了通过扩展函数，
//可以通过代码库中其它地方定义类实例调用的方法，但是如果你需要定义可以通过
//类自身调用的方法，就像伴生对象方法或者Java静态方法该怎么办呢？
//
//举例来说，如果类有一个伴生对象，可以通过在其上定义扩展函数来做到这一点，即类C有一个伴生对象，并且在C.Companion上定义了一个扩展函数func，则可以通过C.fun()来调用它。

class Teacher(val name:String){
    companion object
}
class Coder(val name:String){

}

fun Teacher.Companion.toJson(teacher: Teacher)= "{name:${teacher.name}}"

//Coder 没有伴生对象,这里会报错
//fun Coder.Companion.toJson(coder: Coder)= "{name:${coder.name}}"

fun main(args: Array<String>) {
    val teacher = Teacher("keepon")
    println(Teacher.Companion.toJson(teacher))
}

//当调用toJson就像是它是一个伴生对象定义的方法一样，但是实际上它是作为扩展函数在外部定义的。
//而为了能够为你的类定义扩展，必须在其中声明一个对象，即使是空的。























