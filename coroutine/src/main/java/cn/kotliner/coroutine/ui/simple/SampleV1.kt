package cn.kotliner.coroutine.ui.simple

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

/**
 * Time:2023-05-07 下午 6:42
 * Author:
 * Description:
 */
fun main(args: Array<String>) {
    baseMain { it, frame ->
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
