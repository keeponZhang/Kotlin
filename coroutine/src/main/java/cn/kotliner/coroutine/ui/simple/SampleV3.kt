package cn.kotliner.coroutine.ui.simple

import cn.kotliner.coroutine.async.begin.我要开始协程啦BaseContinuation
import cn.kotliner.coroutine.async.begin.我要开始协程啦OnlyAsyncContext
import cn.kotliner.coroutine.common.HttpError
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import cn.kotliner.coroutine.ui.LOGO_URL
import cn.kotliner.coroutine.ui.Mainkt1.kt.baseMain
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.swing.SwingUtilities
import cn.kotliner.coroutine.async.loadImage.*
import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * Time:2023-05-07 下午 6:42
 * Author:
 * Description:
 */
fun main(args: Array<String>) {
    baseMain { it, frame ->
        log("协程之前")
        我要开始协程啦OnlyAsyncContext() {
            log("协程开始")
            //获取后还是在线程池
            // val imageData = 我要开始加载图片啦不切换线程同步(LOGO_URL)
            val imageData = 我要开始加载图片啦不切换线程异步(LOGO_URL)
            // val imageData = 我要开始加载图片啦不切换线程AsyTask(LOGO_URL)
            // val imageData = 我要开始加载图片啦切换线程AsyTask(LOGO_URL)
            // val imageData = 我要开始加载图片啦UiCotinuationWrapper(LOGO_URL)
            // val imageData = 我要开始耗时操作了block(LOGO_URL)
            log("拿到图片")  //这个运行在哪个线程，是由上面是否切换线程决定的
            frame.setLogo(imageData)
            log("协程结束")
        }
        log("协程之后")
    }
}
