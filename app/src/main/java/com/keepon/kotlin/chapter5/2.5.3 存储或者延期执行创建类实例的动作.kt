package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */

//我们还可以使用 构造方法引用 存储或者延期执行创建类实例的动作，构造方法引用的形式是 在双冒号后指定类的名称：
fun main(args: Array<String>) {
    val createPerson = ::Person
    val p = createPerson("alice",22)
    println(p)
}