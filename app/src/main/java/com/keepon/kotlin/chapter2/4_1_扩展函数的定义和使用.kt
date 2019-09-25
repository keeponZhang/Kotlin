package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
fun String.lastChar():Char {
    println("this表示调用者 $this")
    //this表示调用者
   return this.get(this.length-1)
}

fun main(args: Array<String>) {
    println("kotlin拓展方法".lastChar())
}