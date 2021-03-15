package com.keepon.test

import kotlin.coroutines.experimental.Continuation

fun main(args: Array<String>) {
    var nextStep: Continuation<Unit>? = null
    val step = nextStep!!
    test2 { str -> str + 1 }
    test3 { str -> str + 1 }
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