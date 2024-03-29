package com.bennyhuo.kotlin.coroutines.sampleb

import com.bennyhuo.kotlin.coroutines.delay
import com.bennyhuo.kotlin.coroutines.launch
import com.bennyhuo.kotlin.coroutines.runBlocking
import com.bennyhuo.kotlin.coroutines.scope.GlobalScope
import com.bennyhuo.kotlin.coroutines.utils.log

fun main() = runBlocking {
//    这个block会被调用几次，看外部block挂起次数
    log("runBlocking 1")
    val job = GlobalScope.launch {
        log(2)
        delay(100)
        log(3)
    }
    log(4)
//    要想job里面的调用完，还是需要join的
    job.join()
//     log(5)
//     delay(100)
    log(6)
}