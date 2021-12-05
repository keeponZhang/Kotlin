package com.zhang.test.exception5

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120407669
fun main() = runBlocking {
    GlobalScope.launch {
        supervisorScope {
            val deferred = async {
                log("deferred")
                throw Exception("test")
            }
            log("end block-----------")
        }
    }
    log("end-----")
}
