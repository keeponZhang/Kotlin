package com.example.retrofittest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 *createBy keepon
 */
fun test1() {
//    val coroutine = if (start.isLazy)
//        LazyStandaloneCoroutine(newContext, block) else
//        StandaloneCoroutine(newContext, active = true)
//    coroutine.start(start, coroutine, block)

    // start.invoke<Any, Any>(block, receiver, this as Continuation<*>)
//    start(block, receiver, this)
    GlobalScope.launch {
        println("codesrun in coroutine scope=" + this)

    }
    Thread.sleep(5000)
}