package cn.kotliner.coroutine.ui

import cn.kotliner.coroutine.async.Coroutines2.kt.我要开始加载图片啦3
import cn.kotliner.coroutine.async.我要开始协程啦TwoAsyncContext3_3
import com.bennyhuo.kotlin.coroutines.utils.log
import javax.swing.JFrame.EXIT_ON_CLOSE

/**
 * Created by benny on 5/20/17.
 */

fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true
    //天坑，不同版本表现还不一样
//    ext.kotlin_version = '1.3.10'
//    ext.kotlin_version = '1.2.51'
    frame.onButtonClick {
        log("协程之前")
        我要开始协程啦TwoAsyncContext3_3() {
            log("协程开始")
            try {
                //这里相当于我要开始耗时操作了的方法参数是lambda表达式
                val imageData = 我要开始加载图片啦3(LOGO_URL)
                log("拿到图片")
                frame.setLogo(imageData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        log("协程之后")
    }
}


