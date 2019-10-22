package com.keepon.kotlin.chapter1

import java.io.BufferedReader
import java.io.StringReader

/**
 * createBy	 keepon
 */
//kotlin中的try关键字就像if和when一样，引入了一个表达式，可以把它的值赋给一个变量，并且需要用花括号把语句主体括起来。
//如果主体包含多个表达式，那么整个try表达式的值就是最后一个表达式的值。作者：泽毛

fun readNumber2(reader:BufferedReader){
    val number = try{
        Integer.parseInt(reader.readLine())
    }catch (e :Exception){
        null
    }
    println(number)
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber2(reader)
}

















