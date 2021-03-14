package com.keepon.test

fun main(args: Array<String>) {
    test2 { str -> str + 1 }
}

fun test1(block: (String) -> String) {
    block("3")
}

inline fun test2(block: (String) -> String) {
    test3(block)
}

inline fun test3(block: (String) -> String) {
    block("keepon")
}