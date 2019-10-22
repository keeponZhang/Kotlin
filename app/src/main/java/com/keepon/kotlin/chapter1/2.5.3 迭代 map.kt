package com.keepon.kotlin.chapter1

import java.util.*

/**
 * createBy	 keepon
 */
//更新 map
//这里我们用到了TreeMap，在更新map时，我们可以像使用数组一样，只不过下标变成了key值：


fun  funmap(){
    val binaryReps = TreeMap<Char,String>()
    for(c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("letter = $letter,binary = $binary")
    }
}

fun main(args: Array<String>) {
    funmap()
}











