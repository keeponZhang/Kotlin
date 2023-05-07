package cn.kotliner.coroutine.ui.Mainkt1.kt

import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.MainWindow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.awt.event.ActionEvent
import javax.swing.JFrame
import javax.swing.SwingUtilities

/**
 * createBy	keepon
 */

fun baseMain(listener: (ActionEvent, MainWindow) -> Unit) {
    val frame = MainWindow()
    frame.title = "Coroutine@Bennyhuo"
    frame.setSize(200, 150)
    frame.isResizable = true
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.init()
    frame.isVisible = true
    frame.onButtonClick {
        listener.invoke(it, frame)
    }
}