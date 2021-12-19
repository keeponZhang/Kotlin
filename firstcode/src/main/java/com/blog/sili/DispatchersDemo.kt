package com.blog.sili

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.TimeUnit
import javax.swing.SwingUtilities
import kotlin.concurrent.thread
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.startCoroutine
import kotlin.coroutines.suspendCoroutine

/**
 * createBy	 keepon
 */
class MyContinuation() : Continuation<String> {
    override val context: CoroutineContext = Dispatchers.Unconfined
    override fun resumeWith(result: Result<String>) {
        log("MyContinuation resumeWith 结果 = ${result.getOrNull()}")
    }
}

suspend fun demo() = suspendCoroutine<String> { c ->

    thread(name = "自己创建的线程") {
        TimeUnit.SECONDS.sleep(1)
        log("demo 调用resume回调")
        c.resume("hello")
    }

}

//https://blog.csdn.net/qfanmingyiq/article/details/105184822
fun main() {

    Thread.currentThread().name = "非Ui线程"

    Thread.currentThread().state

    val suspendLambda = suspend {
        log("demo 运行前")
        val resultOne = demo()
        log("demo 运行后")
        //拼接结果
        resultOne
    }
    SwingUtilities.invokeLater {

    }

    val myContinuation = MyContinuation()

    suspendLambda.startCoroutine(myContinuation)

    TimeUnit.HOURS.sleep(1111)
}

