package com.zhang.test.exception8

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120407669
fun main() = runBlocking {
    CoroutineScope(Job()).launch {
        val deferred = async {
            log("deferred-----------")
            throw Exception("test")
        }
        log("end block-----------")
    }
    log("end-------")
}
