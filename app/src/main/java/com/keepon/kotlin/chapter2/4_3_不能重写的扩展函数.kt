package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
open  class View{
   open fun click() {
        println("View click")
    }
}

class Button :View(){
   override fun click(){
        println("Button click")
    }
}

fun  View.showoff() = println("I am a view")
fun  Button.showoff() = println("I am a button")

fun main(args: Array<String>) {
    val view:View = Button()
    //因为Kotinlin会把拓展函数当做静态函数对象，因此实际上调用的是View的拓展函数
    view.showoff()
    //I am a view
}






