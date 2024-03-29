package com.bennyhuo.kotlin.advancedfunctions.eg

import java.io.File

fun main() {
//    groupBy { it } 类似keySelector(element)，此时key为it
//    val key = keySelector(element)

    File("build.gradle").readText() // 1. read file
            .toCharArray() // 2.
            .filter { !it.isWhitespace() } // 3. filter white space
            .groupBy { it }
            .map {
                it.key to it.value.size
            }.let {
                println(it)
            }
}