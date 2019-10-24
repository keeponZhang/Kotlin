package com.keepon.kotlin.chapter7

/**
 * createBy	 keepon
 */

fun printInUppercase(list : List<String>) {
    println(CollectionUtils.uppercaseAll(list));
    println(list.first())
}

fun main(args: Array<String>) {
    val list = listOf("fs","abd")
    printInUppercase(list)

//    [FS, ABD]
//    FS
}