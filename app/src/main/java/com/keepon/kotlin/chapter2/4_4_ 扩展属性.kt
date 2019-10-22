package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */

//扩展属性以var/val关键字开头
//指定扩展属性的名字、类型
//如果是var那么提供get()/set(value : T)方法，而如果是val属性，那么提供get()方法，其中T为属性的类型。

val String.lastChar:Char
   get() = get(length -1)

var StringBuilder.lastChar:Char
    get()= get(length -1)
    //value只是一个参数名称，可以任意命名
    set(value:Char){
        this.setCharAt(length-1,value)
    }

fun main(args: Array<String>) {
    println("Kotlin".lastChar)
    val sb = java.lang.StringBuilder("kotlin?")
    sb.lastChar= '!'
    println(sb)
}






