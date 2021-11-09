package com.bennyhuo.kotlin.coroutines.core

import android.util.Log
import com.bennyhuo.kotlin.coroutines.exception.CoroutineExceptionHandler
import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.CoroutineContext

//启动就好了，不需要结果
class StandardCoroutine(context: CoroutineContext) : AbstractCoroutine<Unit>(context) {
    override fun handleJobException(e: Throwable): Boolean {
        context[CoroutineExceptionHandler]?.handleException(context, e) ?: Thread.currentThread()
            .let {
                log("没人处理异常 --- handleJobException $e")
//                it.uncaughtExceptionHandler.uncaughtException(it, e)
            }
        return true
    }
}