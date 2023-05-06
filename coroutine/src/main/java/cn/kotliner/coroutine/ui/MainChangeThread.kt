package cn.kotliner.coroutine.ui

import cn.kotliner.coroutine.basic.我要basic开始协程啦
import cn.kotliner.coroutine.basic.我要开始basic加载图片啦
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.junit.Before
import javax.swing.JFrame


fun main(args: Array<String>) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true
    //这个是同步
    frame.onButtonClick {
        GlobalScope.launch(Dispatchers.Main) {
            log("我在主线程执行")
            withContext(Dispatchers.IO) {
                log("我在子线程执行")//②
            }
            log("我在哪个线程执行？")//③

        }
    }


}