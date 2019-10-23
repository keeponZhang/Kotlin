package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
data class Client(val name:String ,val postalCode:Int)

fun main(args: Array<String>) {
    val bob = Client("keepon",211)
    //使用自动生成的toString
    println(bob)

    val bob2 = Client("keepon2",212)
    //使用自动生成的equals
    println(bob==bob2)

    val  hashSet = hashSetOf<Client>()
    hashSet.add(bob)
    //使用自动生成的hashCode
    println(hashSet.contains(bob))
}