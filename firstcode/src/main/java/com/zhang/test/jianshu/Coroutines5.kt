package com.zhang.test.jianshu

import kotlinx.coroutines.*

//https://www.jianshu.com/p/2659bbe0df16


fun main(args: Array<String>) = runBlocking<Unit> {
    val deferred = GlobalScope.async {
        println("Throwing exception from async"+ coroutineContext[Job])
        throw IndexOutOfBoundsException()
    }

    delay(1000)
// await() 恢复调用者协程时会重写抛出异常
//    会传入当前的lambda作为complete
    deferred.await()
//    join不会崩溃
    deferred.join()
    println("main end")
}


