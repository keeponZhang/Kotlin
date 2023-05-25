package com.zhang.test.jianshu

import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

//https://www.jianshu.com/p/2659bbe0df16


fun main(args: Array<String>) = runBlocking<Unit> {
    //这种会抛出.会向上抛出
    val deferred = async {
        println("Throwing exception from async" + coroutineContext[Job])
        throw IndexOutOfBoundsException()
    }

    //delay(100)
// await() 恢复调用者协程时会重写抛出异常
//    deferred.await()
    println("main end")
}


