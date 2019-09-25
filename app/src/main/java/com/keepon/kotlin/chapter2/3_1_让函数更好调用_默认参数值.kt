package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
fun <T> joinToString(collection:Collection<T>,sep:String=":",prefix:String="[",postfix:String="]"){
    val  result = StringBuffer(prefix)
    for ((index,element) in collection.withIndex()){
        if(index>0){
            println("index $index  element $element")
            result.append(sep)
        }
        result.append(element)
    }
    result.append(postfix)
    println(result)
}

fun main(args: Array<String>) {
    val list = listOf<Int>(1,2,3)
    joinToString(list,",","{","}")
}