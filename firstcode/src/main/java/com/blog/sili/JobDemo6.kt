package com.blog.sili

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
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
        launch {
            1 / 0
        }
    }
    //job.join()
    TimeUnit.SECONDS.sleep(160)
    println("结束")


}

