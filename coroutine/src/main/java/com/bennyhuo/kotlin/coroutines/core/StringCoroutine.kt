package com.bennyhuo.kotlin.coroutines.core

import com.bennyhuo.kotlin.coroutines.exception.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

//启动就好了，不需要结果
class StringCoroutine(context: CoroutineContext) : AbstractCoroutine<String>(context) {
    override fun handleJobException(e: Throwable): Boolean {
        context[CoroutineExceptionHandler]?.handleException(context, e) ?: Thread.currentThread()
            .let { it.uncaughtExceptionHandler.uncaughtException(it, e) }
        return true
    }
}