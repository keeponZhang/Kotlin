package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
//伴生对象是一个声明在类中的普通对象，它可以有名字，实现一个接口或者有扩展函数或属性。
//假设我们需要在对象和JSON之间进行序列化和反序列化，可以将序列化的逻辑放在伴生对象中。
class Person1(val name:String){
//    在大多数情况下，通过包含伴生对象的类的名字（也就是例子中的Person类）来引用伴生对象，所以不必关心它的名字，如果省略了伴生对象的名字，默认的名字将会分配为Companion。
    //这里的Loader可以去掉
    companion object Loader{
        fun toJson(person1: Person1)="{name:${person1.name}}"
    }

}

fun main(args: Array<String>) {
    val person1 = Person1("keepon")
    println(Person1.Loader.toJson(person1))

}