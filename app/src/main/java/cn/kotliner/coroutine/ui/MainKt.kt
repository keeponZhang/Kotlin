package cn.kotliner.coroutine.ui

import cn.kotliner.coroutine.async.我要开始加载图片啦Uicontinuation
import cn.kotliner.coroutine.async.我要开始协程啦0
import cn.kotliner.coroutine.common.log
import javax.swing.JFrame.EXIT_ON_CLOSE

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

//    frame.onButtonClick {
//        log("协程之前")
//        //DownloadContext(LOGO_URL)是第一个参数
//        我要开始协程啦(DownloadContext(LOGO_URL)) {
//            log("协程开始")
//            try {
//                val imageData = 我要开始耗时操作了 {
//                    我要开始加载图片啦(this[DownloadContext]!!.url)
//                }
//
//                println("thread ="+Thread.currentThread().name)
//                log("拿到图片")
//                frame.setLogo(imageData)
//            } catch(e: Exception) {
//                e.printStackTrace()
//            }
//        }
//        log("协程之后")
//    }




    frame.onButtonClick {
        log("协程之前")
        我要开始协程啦0() {
            log("协程开始")
            try {
                //获取后还是在线程池
//                val imageData = 我要开始加载图片啦0(LOGO_URL)
                ////获取后切换到了主线程
//                val imageData = 我要开始加载图片啦1(LOGO_URL)
                //Uicontinuation内进行线程切换
                val imageData = 我要开始加载图片啦Uicontinuation(LOGO_URL)
                println("thread ="+Thread.currentThread().name)
                log("拿到图片")
                frame.setLogo(imageData)
            } catch(e: Exception) {
                e.printStackTrace()
            }
        }
        log("协程之后")
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


