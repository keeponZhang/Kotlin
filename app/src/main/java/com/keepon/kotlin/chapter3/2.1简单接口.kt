package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
//1.一个简单的Kotlin接口使用 interface 关键字来声明，所有实现这个接口的非抽象类都需要实现接口中定义的抽象方法。
//2.Kotlin在类名后面使用 冒号 代替了Java中的extends和implements关键字，一个类可以实现多个接口，但是只能继承一个类。
//3.override修饰符用来标注被重写的父类或者接口的方法和属性，并且是 强制要求 的。



interface  Clickable{
    fun click()
    //在接口中定义方法的默认实现
    fun showOff() = println("I am show off in Clickable")

//    如果一个类实现了两个接口，而这两个接口定义了相同的方法
    fun showOff2()
}
interface Focousable{
    //在接口中定义方法的默认实现
    fun showOff() = println("I am show off in Focousable")
    fun showOff2() = println("I am show off2 in Focousable")
}

class Button : Clickable,Focousable{

    override fun showOff2() {

    }

    override fun showOff() {
      //如果一个类实现了两个接口，而这两个接口定义了相同的方法,调用父类方法时，要显示指明父类名字
        super<Clickable>.showOff()
        println("I am showoff in Button")
    }

    override fun click() {
        println("I was clicked in Button")
    }

}

fun main(args: Array<String>) {
    Button().click()
    Button().showOff()
}