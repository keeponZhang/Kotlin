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
        HttpService.service.getLogo(LOGO_URL)
            .enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        val imageData = response.body()?.byteStream()?.readBytes()
                        if (imageData == null) {
                            throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
                        } else {
                            SwingUtilities.invokeLater {
                                frame.setLogo(imageData)
                            }
                        }
                    } else {
                        throw HttpException(response.code())
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    throw HttpException(HttpError.HTTP_ERROR_UNKNOWN)
                }
            })
    }
}