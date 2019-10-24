package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */

//在上面的例子中，我们演示了 如何让你把代码块作为参数传递给函数，但是如果要当做参数传递的代码已经被定义成了函数，
//这时候就需要 把函数转换成一个值，这种方式称为 成员引用。

val getAge = Person :: age
val getAge2 = Person :: getAge2

//提供了简明的语法，来创建一个 调用单个方法或者访问单个属性的函数值，双冒号把 类名称 与 你要引用的成员（一个方法或者属性）名称 隔开。
//
//成员引用和调用该函数的lambda具有一样的类型，所以可以互换使用：
fun test2(){
    val people = listOf<Person>(Person("alice",22), Person("keeon",22))
    people.maxBy(Person :: age)
    people.maxBy(getAge2)
}






