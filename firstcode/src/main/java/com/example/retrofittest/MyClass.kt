package com.example.retrofittest.MyClass.kt

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 *createBy keepon
 */
class MyClass : CoroutineScope by CoroutineScope(Dispatchers.Default) {

    fun doWork() {
        launch {
            for (i in 0..10) {
                println("MyClass launch1 $i -----")
                delay(100)
            }
        }
    }

    fun destroy() {
        (this as CoroutineScope).cancel()
    }
}

fun main() {

    val myClass = MyClass()

    // 因为myClass已经是一个CoroutineScope对象了，当然也可以通过这种方式来启动协程
    myClass.launch {
        for (i in 0..10) {
            println("MyClass launch1 $i *****")
            delay(100)
        }
    }

    myClass.doWork()

    Thread.sleep(500) // 让协程工作一会

    myClass.destroy() // myClass需要被回收了！

    Thread.sleep(500) // 等一会方便观察输出
}
