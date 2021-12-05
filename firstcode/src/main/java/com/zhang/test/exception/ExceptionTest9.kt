package com.zhang.test.exception9

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120407669
fun main() = runBlocking {
    GlobalScope.launch {
        val deferred = async {
            throw Exception("test")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            log("异常-----------")
        }
        log("end block-----------")
    }
    log("end-------")
}
