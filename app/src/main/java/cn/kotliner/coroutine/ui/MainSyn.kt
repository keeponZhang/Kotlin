package cn.kotliner.coroutine.ui

import cn.kotliner.coroutine.basic.我要basic开始协程啦
import cn.kotliner.coroutine.basic.我要开始basic加载图片啦
import cn.kotliner.coroutine.common.log
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
        log("basic协程之前")
        我要basic开始协程啦() {
            try {
                log("basic协程开始")
                val imageData = 我要开始basic加载图片啦(LOGO_URL)
                log("basic拿到图片")
                frame.setLogo(imageData)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        log("basic协程之后")
    }

//    frame.onButtonClick {
//        HttpService.service.getLogo(LOGO_URL)
//                .enqueue(object : Callback<ResponseBody> {
//                    override fun onResponse(
//                            call: Call<ResponseBody>,
//                            response: Response<ResponseBody>) {
//                        if (response.isSuccessful) {
//                            val imageData = response.body()?.byteStream()?.readBytes()
//                            if (imageData == null) {
//                                throw HttpException(HttpError.HTTP_ERROR_NO_DATA)
//                            } else {
//                                SwingUtilities.invokeLater {
//                                    frame.setLogo(imageData)
//                                }
//                            }
//                        } else {
//                            throw HttpException(response.code())
//                        }
//                    }
//
//                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                        throw HttpException(HttpError.HTTP_ERROR_UNKNOWN)
//                    }
//
//                })
//    }
}