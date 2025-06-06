/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from coroutines-basics.md by Knit tool. Do not edit.
package kotlinx.coroutines.guide.exampleBasic04_2

import kotlinx.coroutines.*

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    launch {
        delay(200L)
        println("Task from runBlocking")
    }
    println("1=" + coroutineContext[Job])
    println("1=" + this)
    coroutineScope { // 创建一个协程作用域
        println("2=" + coroutineContext[Job])
        println("2=" + this)

        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }
    //这个执行后会挂起，执行完成才会恢复执行下面最后一行的代码

    println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}

