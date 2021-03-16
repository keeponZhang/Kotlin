package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//String表示是String类的拓展函数,拓展函数其实会被编译成静态函数
fun String.lastChar():Char {
    println("this表示调用者 $this")
    //this表示调用者
   return this.get(this.length-1)
}

fun main(args: Array<String>) {
    println("kotlin拓展方法".lastChar())
}