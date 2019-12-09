package cn.kotliner.coroutine.ui.Mainkt2.kt

import cn.kotliner.coroutine.async.我要开始加载图片啦Uicontinuation
import cn.kotliner.coroutine.async.我要开始加载图片啦不切换线程
import cn.kotliner.coroutine.async.我要开始加载图片啦不切换线程同步
import cn.kotliner.coroutine.async.我要开始加载图片啦不切换线程异步
import cn.kotliner.coroutine.async.我要开始加载图片啦切换线程
import cn.kotliner.coroutine.async.我要开始协程啦BaseContinuation
import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.common.log
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.MainWindow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.JFrame
import javax.swing.SwingUtilities

/**
 * createBy	keepon
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
        我要开始协程啦BaseContinuation() {
            log("协程开始")
            try {
                //获取后还是在线程池
//                val imageData = 我要开始加载图片啦不切换线程同步(LOGO_URL)
//                val imageData = 我要开始加载图片啦不切换线程异步(LOGO_URL)
//                val imageData = 我要开始加载图片啦不切换线程(LOGO_URL)
                ////获取后切换到了主线程
//                val imageData = 我要开始加载图片啦切换线程(LOGO_URL)
                //Uicontinuation内进行线程切换
               val imageData = 我要开始加载图片啦Uicontinuation(LOGO_URL)
                println("thread =" + Thread.currentThread().name)
                log("拿到图片")  //这个运行在哪个线程，是由上面是否切换线程决定的
                frame.setLogo(imageData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        log("协程之后")
    }
}