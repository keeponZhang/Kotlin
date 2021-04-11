package com.bennyhuo.kotlin.coroutinebasics.eg.lua

import com.bennyhuo.kotlin.coroutinebasics.utils.log

suspend fun main() {

    SymCoroutine.main {
        log("main", 0)
        val result = transfer(SymCoroutines.coroutine2, 3)
        log("main end", result)
    }
}
