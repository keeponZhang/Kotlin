package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */
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
      //如果一个类实现了两个接口，而这两个接口定义了相同的方法,调用父类方法是，要显示指明父类名字
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