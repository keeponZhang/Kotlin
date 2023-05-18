package com.bennyhuo.kotlin.coroutine.ch01

suspend fun main() {
    println("A")
   kotlinx.coroutines.delay(1)
    println("B")
}