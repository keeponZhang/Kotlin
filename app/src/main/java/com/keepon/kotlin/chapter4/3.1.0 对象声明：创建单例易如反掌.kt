package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */

//在Java中，单例模式通常是使用private构造方法，并且用静态字段来持有这个类仅有的实例。
//
//而在Kotlin中，通过使用对象声明功能，将类声明与该类的单一实例声明结合到了一起。


object Person {
    var name: String = "Default Name"
    var age: Int = 15
}
//下面这个会报错
//一个对象声明可以包含属性、方法、初始化语句块等的声明，但是 不允许声明构造方法，这是因为对象在定义的时候就已经创建了，不需要在其他地方调用构造方法。
//object Person2(val email:String) {
//    var name: String = "Default Name"
//    var age: Int = 15
//}

fun main(args: Array<String>) {
    //对象声明允许使用对象名加.字符的方式来调用方法和访问属性
    println("Name=${Person.name},Age=${Person.age}")
}

//对象声明通过object关键字引入，一个对象声明可以非常高效地以一句话来定义一个类和一个该类的变量。
//一个对象声明可以包含属性、方法、初始化语句块等的声明，但是 不允许声明构造方法，这是因为对象在定义的时候就已经创建了，不需要在其他地方调用构造方法。
//对象声明允许使用对象名加.字符的方式来调用方法和访问属性。














