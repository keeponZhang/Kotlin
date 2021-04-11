package com.bennyhuo.kotlin.advancedfunctions.sams

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main() {
    val executor: ExecutorService = Executors.newSingleThreadExecutor()

    //这里其实就是匿名内部类实现
    executor.submit(object : Runnable {
        override fun run() {
            println("run in executor.")
        }
    })

    //这里最终也是匿名内部类实现， Runnable表示会生成一个 Runnable类型的内部类
//    { println("run in executor2.") }这个是一体的
    executor.submit(Runnable {
        println("run in executor2.")
    })


    //java方法和接口支持
    executor.submit { println("run in executor3.") }

    println("run in main thread.")

    submitRunnable {
        println("Hello")
    }

    //kotlin1.3支持kotlin函数
    submit { }
}

fun Runnable(block: () -> Unit): Runnable {
    return object : Runnable {
        override fun run() {
            block()
        }
    }
}

fun submitRunnable(runnable: Runnable) {
    runnable.run()
}

fun submit(invokable: Invokable) {
    invokable.invoke()
}

typealias FunctionX = () -> Unit

fun submit(lambda: FunctionX) {
}

interface Invokable {
    fun invoke()
}



