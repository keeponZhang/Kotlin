package cn.kotliner.coroutine.async.loadImage

import cn.kotliner.coroutine.async.AsyncTask
import cn.kotliner.coroutine.common.HttpException
import cn.kotliner.coroutine.common.HttpService
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//CoroutineContext.()相当于（CoroutineContext）
suspend fun <T> 我要开始耗时操作了block(block: CoroutineContext.() -> T) =
    suspendCoroutine<T> { continuation ->
        log("我要开始耗时操作了 异步任务开始前")
        AsyncTask {
            try {
                //这样写的好处是已经给block传入了默认的输入参数，block里面只需要处理返回值，就是返回T
                //这里传context，其实是因为context里面可以带变量
                continuation.resume(block(continuation.context))
            } catch (e: Exception) {
                continuation.resumeWithException(e)
            }
        }.execute()
    }
