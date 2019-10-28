package com.keepon.kotlin.chapter9

/**
 * createBy	 keepon
 */

//委托属性发挥作用的另一种常见用法是 用在动态定义的属性集的对象中，这样的对象有时被称为 自订对象。例如考虑一个联系人管理系统，
//可以用来存储有关联系人的任意信息，系统中的每个人都有一些属性需要特殊处理（例如名字），
//以及每个人特有的数量任意的额外属性（例如，最小的孩子的生日）。

//实现这种系统的一种方法是将人的所有属性存储在map中，不确定提供属性，来访问需要特殊处理的信息。

class Person6 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
        println("attrName=$attrName,value=$value")
    }
    //把 map 作为委托属性。
    val name2: String by _attributes
}

fun main(args: Array<String>) {
    val p = Person6()
    val data = mapOf("name2" to "Dmitry2", "company" to "JetBrains")
    for ((attrName, value) in data)
        p.setAttribute(attrName, value)
    println(p.name2)
}

//因为标准库已经在标准map和MutableMap接口上定义了getValue和setValue扩展函数，所以可以在这里直接调用。


















































