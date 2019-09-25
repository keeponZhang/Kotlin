package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */

fun main(args: Array<String>) {
    val list = listOf(1,2,4)
    joinToString(list,prefix = "{",postfix = "}",sep = ",")
}