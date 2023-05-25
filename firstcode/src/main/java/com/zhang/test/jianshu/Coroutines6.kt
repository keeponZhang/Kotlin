package com.zhang.test.jianshu

import kotlinx.coroutines.*

//https://www.jianshu.com/p/2659bbe0df16


fun main(args: Array<String>) = runBlocking<Unit> {
    //这个也不会抛出异常
   val job = GlobalScope.launch {
        println("Throwing exception from launch")
        throw IllegalStateException()
    }
    //调用join会崩溃，不调用不会崩溃
    job.join()
// await() 恢复调用者协程时会重写抛出异常
//    deferred.await()
    println("main end")

    //val scope = CoroutineScope(Job())
    //scope.launch(SupervisorJob()) {
    //    launch {
    //        // Child 1
    //    }
    //    launch {
    //        // Child 2
    //    }
    //}
}


