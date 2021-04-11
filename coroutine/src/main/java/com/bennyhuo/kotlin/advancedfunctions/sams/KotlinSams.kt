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
    //也可以叫做匿名内部类的简写
    executor.submit(Runnable {
        println("run in executor2.")
    })


    //java方法和接口支持（kotlin的lambda表达式本身是有自己类型的（）->Unit->Runnable）
    executor.submit { println("run in executor3.") }

    println("run in main thread.")

    //kotlin1.3才支持kotlin函数，且需要加编译字段
//    submitRunnable {
//        println("Hello")
//    }

    //kotlin1.3支持kotlin函数，现在会报错
//    submit2 { }
    submit2(object : Invokable {
        override fun invoke() {
        }
    })
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

fun submit2(invokable: Invokable) {
    invokable.invoke()
}

typealias FunctionX = () -> Unit

fun submit(lambda: FunctionX) {
}

interface Invokable {
    fun invoke()
}



