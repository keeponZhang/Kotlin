package com.zhang.test.exception3

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120407669
fun main() = runBlocking {
    val coroutineScope = CoroutineScope(Job())
    coroutineScope.launch {
        throw Exception("test")
    }
    coroutineScope.launch {
        println("111111111")
        log("xys test")
    }
    println("--------------")
}

