package com.example.retrofittest

import com.bennyhuo.kotlin.coroutinebasics.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.JFrame
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true
    frame.onButtonClick {
//        test1()
//        test2()
//    test3()
//        test4()
//    test5()
//    test6()
        //获取一个全局CoroutineScope
//    GlobalScope.launch {
//        test8()
//    }
//        test7()
//    test9()
//        test11()
        test12()
//        test13()
//        test14()
//
    }
}



fun main() {
//    test2()
//    test3()
//    test4()
//    test5()
//    test6()


//    test10()

//    runBlocking {
//        getAppData()
//    }
//    test11()
}

private suspend fun sum() {
    //Dispatchers.Default是CoroutineDispatcher的子类，后者的key是ContinuationInterceptor，返回的Continuation
    // 是DispatchedContinuation
    val result = withContext(Dispatchers.Default) {
        5 + 5
        println("Thread name = " + Thread.currentThread().name)
        launch { }
    }
}



private fun test1() {
//    val coroutine = if (start.isLazy)
//        LazyStandaloneCoroutine(newContext, block) else
//        StandaloneCoroutine(newContext, active = true)
//    coroutine.start(start, coroutine, block)
    GlobalScope.launch {
        println("codesrun in coroutine scope=" + this)

    }
    Thread.sleep(5000)
}

private fun test2() {
    val launch = GlobalScope.launch {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")

    }
    Thread.sleep(100)
    launch.cancel()
}

private fun test3() {
    runBlocking {
        println("codes run in coroutine scope")
        delay(1500)
        println("codes run in coroutine scope finished")

    }
}

private fun test4() {
    runBlocking {
//        注意这里的launch函数和我们刚才所使用的GlobalScope.launch函数不同。首先它必须在
//        协程的作用域中才能调用，其次它会在当前协程的作用域下创建子协程。子协程的特点是如果
//        外层作用域的协程结束了，该作用域下的所有子协程也会一同结束。
        launch {
            println("launch1=" + this)
            delay(1000)
            println("launch1 finished")
        }
        launch {
            println("launch2=" + this)
            delay(1000)
            println("launch2 finished")
        }
    }
}

private fun test5() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(100000) {
            launch {
                println(".")
            }
        }
    }
    val end = System.currentTimeMillis()
    println(end - start)
}

private fun test6() {
    val job = Job()
    val scope = CoroutineScope(job)
    //launch的是拥有协程作用域的
    scope.launch {
        // do something
    }
    job.cancel()
}

private fun test7() {
    // coroutineScope函数和runBlocking函数还有点类似，它可以保证其作用域内的所
//    有代码和子协程在全部执行完之前，外部的协程会一直被挂起
    runBlocking {
        println(" test70:" + this);
        coroutineScope {
            println(" test71:" + this);
            launch {
                println(" test72:" + this);
                for (i in 1..10) {
                    println(i)
                    delay(1000)
                }
            }
        }
        println("coroutineScope finished")
    }
    println("runBlocking finished")
}

private suspend fun test8() {
    printDot1()
}
// = 号会报错
//suspend fun printDot0() = {
//    println(".")
//    delay(1000)
//}

private fun test9() {
    runBlocking { printDot() }
}

private fun test10() {
    runBlocking {
        val start = System.currentTimeMillis()
        val deferred1 = async {
            delay(1000)
            5 + 5
        }
        val deferred2 = async {
            delay(1000)
            4 + 6
        }
        println("result is ${deferred1.await() + deferred2.await()}.")
        val end = System.currentTimeMillis()
        println("cost ${end - start} milliseconds.")
    }
}

fun test11() {
//    我来解释一下这段代码。调用withContext()函数之后，会立即执行代码块中的代码，同时
//    将外部协程挂起。当代码块中的代码全部执行完之后，会将最后一行的执行结果作为
//    withContext()函数的返回值返回，因此基本上相当于val result = async{ 5 + 5
//    }.await()的写法。唯一不同的是，withContext()函数强制要求我们指定一个线程参数，
//    关于这个参数我准备好好讲一讲。
    runBlocking {
        val result = sum()
        launch { }
        println(result)
    }
}
fun test12() {
//    我来解释一下这段代码。调用withContext()函数之后，会立即执行代码块中的代码，同时
//    将外部协程挂起。当代码块中的代码全部执行完之后，会将最后一行的执行结果作为
//    withContext()函数的返回值返回，因此基本上相当于val result = async{ 5 + 5
//    }.await()的写法。唯一不同的是，withContext()函数强制要求我们指定一个线程参数，
//    关于这个参数我准备好好讲一讲。
    runBlocking {
        val result = withContext(TestContext()) {
            println("Thread name = " + Thread.currentThread().name)
            delay(1000)
            5 + 5
        }
        log("---------")
        delay(100)
    }
}
suspend fun printDot() {
    println("printDot")
    delay(1000)
    println("printDot.end")
    //不能调用launche函数
//    launch{
//
//    }
}
fun test13() {
    runBlocking {
        try {
            supervisorScope {
                launch { // “1”
                    println("a")
                }
                launch {// “2”
                    println("b")
                    launch {// “3”
                        delay(1000)
                        println("c")
                        throw ArithmeticException("Hey!!")
                    }
                }
                val job = launch {// “4”
                    println("d")
                    delay(2000)
                    println("e")
                }
                job.join()
                println("f")
            }
        } catch (e: Exception) {
            println("g")
        }
        println("h")
    }
}

fun test14() {
    runBlocking {
        try {
            coroutineScope {
                launch { // “1”
                    println("a")
                }
                launch(Dispatchers.IO) {// “2”
                    println("b" + Thread.currentThread().name)
                    launch {// “3”
                        delay(1000)
                        println("c")
                        throw ArithmeticException("Hey!!")
                    }
                }
                val job = launch {// “4”
                    println("d")
                    delay(2000)
                    println("e")
                }
                job.join()
                println("f")
            }
        } catch (e: Exception) {
            println("g")
        }
        println("h")
    }
}
//可以借用coroutineScope
//虽然看上去coroutineScope函数和runBlocking函数的作用是有点类似的，但是
//coroutineScope函数只会阻塞当前协程，既不影响其他协程，也不影响任何线程，因此是不
//会造成任何性能上的问题的。而runBlocking函数由于会挂起外部线程，如果你恰好又在主线
//程中当中调用它的话，那么就有可能会导致界面卡死的情况，所以不太推荐在实际项目中使
//用。
suspend fun printDot1() = coroutineScope {
    println("printDot1.")
    delay(5000)
    println("printDot1.end")
    launch { }
}

suspend fun getAppData() {
    try {
        val appList = ServiceCreator.create<AppService>().getAppData()
                .await() // 这段代码想运行通过，需要将BASE_URL中的地址改成http://localhost/
        println(appList)
        // 对服务器响应的数据进行处理
    } catch (e: Exception) {
        // 对异常情况进行处理
        e.printStackTrace()
    }
}

suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if (body != null) continuation.resume(body)
                else continuation.resumeWithException(RuntimeException("response body is null"))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }
        })
    }
}