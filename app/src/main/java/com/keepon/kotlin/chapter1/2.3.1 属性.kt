package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */

//当声明属性的时候，就声明了对应的访问器（只读属性有一个gettter，而可变属性则有getter/setter），例如下面的例子，声明了只读的name属性，可变的isMarried属性，其赋值和读取的方法如下所示：
class Person( val name:String, var isMarried:Boolean){

}


fun personFunC(){
    val person = Person("keepon",false)
    println("${person.name} isMarried ${person.isMarried}")
    person.isMarried = true
    println("${person.name} isMarried ${person.isMarried}")
}

fun main(args: Array<String>) {
    personFunC()
}

