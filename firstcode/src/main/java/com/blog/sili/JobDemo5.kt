package com.blog.sili

import kotlinx.coroutines.*
import java.util.concurrent.TimeUnit

/**
 * createBy	 keepon
 */

fun main() {
    val eChild = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("子协异常处理器" + throwable.localizedMessage)
    }

    val eParent = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("父协程" + throwable.localizedMessage)
    }

    //创建一个Job
    val job = GlobalScope.launch(eParent) {

        launch(eChild) {
            val d = 1 / 0
        }

        //为了让子协程完成
        delay(100)

        println("协程完成")
    }

    TimeUnit.SECONDS.sleep(1)
    println("结束")


}

