package cn.kotliner.coroutine.ui

import cn.kotliner.coroutine.async.DownloadContext
import cn.kotliner.coroutine.async.我要开始加载图片啦4
import cn.kotliner.coroutine.async.我要开始加载图片啦4_0
import cn.kotliner.coroutine.async.我要开始协程啦自定义Context使用ContextContinuation
import cn.kotliner.coroutine.async.我要开始耗时操作了4_1
import cn.kotliner.coroutine.common.log
import javax.swing.JFrame.EXIT_ON_CLOSE
import kotlin.coroutines.experimental.ContinuationInterceptor

/**
 * Created by benny on 5/20/17.
 */
const val LOGO_URL = "http://www.imooc.com/static/img/index/logo.png?t=1.1"

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true

    frame.onButtonClick {
        log("协程之前")
//        DownloadContext(LOGO_URL)是第一个参数
        我要开始协程啦自定义Context使用ContextContinuation() {
            log("协程开始")
            try {
                //这里相当于我要开始耗时操作了的方法参数是lambda表达式
                val imageData = 我要开始耗时操作了4_1() {
                    //这里表示lambda表达式传入的参数是CoroutineContext，返回的是ByteArray类型
                    //可以调用this[DownloadContext]
                    log("this[ContinuationInterceptor] " + this[ContinuationInterceptor])
//                    println("this[MYKey] " + this[AsyncContext2]?.test)
                    我要开始加载图片啦4_0(this[DownloadContext]!!.url)
                }

                log("拿到图片")
                frame.setLogo(imageData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        log("协程之后")
    }
}


