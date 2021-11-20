package cn.kotliner.coroutine.ui.Mainkt2.kt

import cn.kotliner.coroutine.async.Coroutines2_simple.kt.我要开始加载图片啦不切换线程同步2_0_simple
import cn.kotliner.coroutine.async.Coroutines2_simple.kt.我要开始加载图片啦不切换线程同步2_0_simple2
import cn.kotliner.coroutine.async.我要开始协程啦BaseContinuation
import com.bennyhuo.kotlin.coroutines.utils.log
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.MainWindow
import javax.swing.JFrame
import kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED

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
    COROUTINE_SUSPENDED
    frame.onButtonClick {
        log("协程之前")
        我要开始协程啦BaseContinuation() {
            log("协程开始")
            //获取后还是在线程池
            val imageData = 我要开始加载图片啦不切换线程同步2_0_simple2(LOGO_URL)
            log("拿到图片")  //这个运行在哪个线程，是由上面是否切换线程决定的
//            frame.setLogo(imageData)
            log("协程结束")
        }
        log("协程之后")
    }
}
//BaseContinuationImpl的resumeWith方法很重要，会调用invokeSuspend方法，就是反编译字节码生成的invokeSuspend
// block.startCoroutine(BaseContinuation(EmptyCoroutineContext))执行后