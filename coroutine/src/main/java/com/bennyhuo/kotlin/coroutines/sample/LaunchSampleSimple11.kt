package com.bennyhuo.kotlin.coroutines.sample.sample5

import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.scope.coroutineScope
import com.bennyhuo.kotlin.coroutines.scope.supervisorScope
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.suspendCoroutine

//响应取消的是响应调用的协程,启动一个协程需要两个Continuation,一个是完成时用的，一个是返回的
suspend fun main() {

    val job = GlobalScope.launch() {
//        其实就是能拿到scopeContext，即是当前的context
        log("日志1:$scopeContext")
//        启动的时候能拿到外层的scopeContext

        getNetworkData()
        getNetworkData2()
        launch {
            log("日志4:$scopeContext")
        }
//        跟外层用的是一个作用域
        supervisorScope {
            log("日志5:$scopeContext")
        }
        //   跟外层用的是一个作用域
        coroutineScope {
            log("日志6:$scopeContext")
        }
    }
    log(job.isActive)
    job.join()
}

suspend fun getNetworkData(): Any? {
//    coroutineScope {
//        log("日志3:$scopeContext")
//    }
    log("日志3_2")
    return 2
}

suspend fun getNetworkData2(): Any? = suspendCoroutine {
    1
}
