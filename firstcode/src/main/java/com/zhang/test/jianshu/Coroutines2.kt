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
suspend fun requestToken(): Token {
    log("requestToken ${Thread.currentThread().name}")
    delay(100)
    return Token()
}   // 挂起函数

suspend fun createPost(token: Token, item: Item): Post {
    return Post()
}  // 挂起函数

fun processPost(post: Post) {
    log("handlePost")
}


fun postItem(item: Item) {
    GlobalScope.launch {
        val token = requestToken()
        val post = createPost(token, item)
        processPost(post)
    }
}
fun postItem2(item: Item) {
    GlobalScope.launch {
        // async { requestToken() } 新建一个协程，可能在另一个线程运行
        // 但是 await() 是挂起函数，当前协程执行逻辑卡在第一个分支，第一种状态，当 async 的协程执行完后恢复当前协程，才会切换到下一个分支
        val token = async {
            requestToken()
        }.await()
        // 在第二个分支状态中，又新建一个协程，使用 await 挂起函数将之后代码作为 Continuation 放倒下一个分支状态，直到 async 协程执行完
        val post = async { createPost(token, item) }.await()
        // 最后一个分支状态，直接在当前协程处理
        processPost(post)
    }
}

suspend fun main(args: Array<String>) {
    // 创建一个单线程的协程调度器，下面两个协程都运行在这同一线程上
//    val coroutineDispatcher = newSingleThreadContext("ctx")
    // 启动协程 1
    val launch = GlobalScope.launch {
        log("the first coroutine 1")
        delay(200)
        log("the first coroutine 2")
    }
    launch.join()
    println("-----------")
//    test()
//    test2()
}

fun test2() = runBlocking {
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

private fun test() {
    val coroutineDispatcher = newSingleThreadContext("ctx")
    // 启动协程 1
    GlobalScope.launch(coroutineDispatcher) {
        log("the first coroutine 1")
        delay(200)
        log("the first coroutine 2")
    }
    // 启动协程 2
//    GlobalScope.launch(coroutineDispatcher) {
//        log("the second coroutine 1")
//        delay(100)
//        log("the second coroutine 2")
//    }
    // 保证 main 线程存活，确保上面两个协程运行完成
}