package com.example.helloworld

/**
 *createBy keepon
 */
class Test {
}

fun main(args: Array<String>) {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
    val newList = list.filter { it.length <= 5 }
        .map { it.toUpperCase() }
    // Singleton.INSTANCE.singletonTest()
    Singleton.singletonTest()
}