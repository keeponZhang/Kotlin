package com.zhang.test.jianshu

import com.bennyhuo.kotlin.coroutines.utils.log
import com.zhang.test.jianshu.bean.Item
import com.zhang.test.jianshu.bean.Post
import com.zhang.test.jianshu.bean.Token
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext

suspend fun requestToken(): Token {
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
        val token = async { requestToken() }.await()
        // 在第二个分支状态中，又新建一个协程，使用 await 挂起函数将之后代码作为 Continuation 放倒下一个分支状态，直到 async 协程执行完
        val post = async { createPost(token, item) }.await()
        // 最后一个分支状态，直接在当前协程处理
        processPost(post)
    }
}

fun main(args: Array<String>) {
    // 创建一个单线程的协程调度器，下面两个协程都运行在这同一线程上
    val coroutineDispatcher = newSingleThreadContext("ctx")
    // 启动协程 1
    GlobalScope.launch(coroutineDispatcher) {
        log("the first coroutine 1")
        delay(200)
        log("the first coroutine 2")
    }
    // 启动协程 2
    GlobalScope.launch(coroutineDispatcher) {
        log("the second coroutine 1")
        delay(100)
        log("the second coroutine 2")
    }
    // 保证 main 线程存活，确保上面两个协程运行完成
    Thread.sleep(500)
}