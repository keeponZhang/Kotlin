package cn.kotliner.coroutine.ui.Mainkt2.kt

import cn.kotliner.coroutine.async.Coroutines2.kt.我要开始加载图片啦切换线程AsyTask_2_3
import cn.kotliner.coroutine.async.我要开始协程啦BaseContinuation
import cn.kotliner.coroutine.common.log
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.MainWindow
import javax.swing.JFrame

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
        //这个block是suspend block
        我要开始协程啦BaseContinuation() {
            log("协程开始")
            try {
                //获取后还是在线程池
                val imageData = 我要开始加载图片啦切换线程AsyTask_2_3(LOGO_URL)
                //Uicontinuation内进行线程切换
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