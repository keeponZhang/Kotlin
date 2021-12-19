package com.blog.sili

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * createBy	 keepon https://fanmingyi.blog.csdn.net/article/details/105623638
 */
fun main() {
    //创建一个Job
    val job = GlobalScope.launch {
        Thread.sleep(100)
        println("协程完成")
    }
    //第一个监听
    val disposableOne = job.invokeOnCompletion {
        println("disposableOne 完成")
    }
    //第二个监听
    val disposableTwo = job.invokeOnCompletion {
        println("disposableTwo 完成")

    }
    //第三个监听
    val disposableThree = job.invokeOnCompletion {
        println("disposableThree 完成")
    }

    TimeUnit.SECONDS.sleep(1)
    println("结束")
}
