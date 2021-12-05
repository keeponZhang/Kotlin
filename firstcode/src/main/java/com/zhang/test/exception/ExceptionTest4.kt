package com.zhang.test.exception4

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120407669
fun main() = runBlocking {
    val coroutineScope = CoroutineScope(SupervisorJob())
    coroutineScope.launch {
        throw Exception("test")
    }
    log("xys begin")
    val launch = coroutineScope.launch {
        println("111111111")
        log("xys test")
        println("333333")
    }
    launch.join()
    println("---------end-----")
}
