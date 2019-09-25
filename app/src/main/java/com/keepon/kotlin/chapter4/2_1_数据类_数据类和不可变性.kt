package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
data class Client2(val name:String ,val postalCode:Int)

fun main(args: Array<String>) {
    val bob = Client2("keepon",211)

    println(bob.copy(postalCode = 110))
}