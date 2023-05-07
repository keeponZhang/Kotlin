package com.zhang.test.jianshu

import com.bennyhuo.kotlin.coroutines.utils.log
import com.zhang.test.jianshu.bean.Item
import com.zhang.test.jianshu.bean.Post
import com.zhang.test.jianshu.bean.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
//https://www.jianshu.com/p/2659bbe0df16

fun testRunBlocking() = runBlocking {
    launch { // 默认继承 parent coroutine 的 CoroutineDispatcher，指定运行在 main 线程
        log("main runBlocking: I'm working in thread ")
        delay(100)
        log("main runBlocking: After delay in thread ")
    }
    launch(Dispatchers.Unconfined) {
        log("Unconfined      : I'm working in thread ")
        delay(100)
        log("Unconfined      : After delay in thread ")
    }
}

