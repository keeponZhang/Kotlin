package cn.kotliner.coroutine.ui.Mainkt2.kt

import cn.kotliner.coroutine.async.Coroutines2.kt.我要开始加载图片啦不切换线程异步2_1
import cn.kotliner.coroutine.async.我要开始协程啦BaseContinuation
import cn.kotliner.coroutine.common.log
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.MainWindow
import javax.swing.JFrame

/**
 * createBy	keepon
 * CoroutinesLibraryKt.kotlin_metadata
 * IntrinsicsJvm.kt 很重要 org.jebrain 1.3.41
 * CoroutineImpl
 * CoroutineIntrinsics 调用拦截器的类，必须找key为ContinuationInterceptor的
 * SafeContinuation (getResult方法挺重要(有可能在回调之前就调用了))
 *
 * CoroutineImpl@kotlin.internal.InlineOnly
internal inline fun processBareContinuationResume(completion: Continuation<*>, block: () -> Any?) {
try {
val result = block()
if (result !== COROUTINE_SUSPENDED) {
@Suppress("UNCHECKED_CAST")
(completion as Continuation<Any?>).resume(result)
}
} catch (t: Throwable) {
completion.resumeWithException(t)
}
}


 */
fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
        我要开始协程啦BaseContinuation() { //里面变成doResume里面的方法
            log("协程开始")
            //不用try catch，内部有try catch，异常后会回调失败的方法
//            throw RuntimeException("keepon")
            //获取后还是在线程池看
            test2()
            testsuspend()
            try {
                val imageData = 我要开始加载图片啦不切换线程异步2_1(LOGO_URL)
                log("拿到图片")  //这个运行在哪个线程，是由上面是否切换线程决定的
                frame.setLogo(imageData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        log("协程之后")
    }
}

//suspend的函数默认会多生成一个参数Continuation，并把外层的Continuation传入
suspend fun testsuspend() {
    println("suspend test")
}

fun test2() {
    println("test2")
}


