package com.example.studycoroutine.chapter.two

import com.bennyhuo.kotlin.coroutines.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext

/**
 * Time:2025/6/6 17:02
 * Author:
 * Description:
 */
//com.example.studycoroutine.chapter.two.CoroutineRunFour.kt
class MyCoroutine() : Continuation<String> {
    override fun resumeWith(result: Result<String>) {

        log("MyCoroutine 回调resumeWith 返回的结果 " + result.getOrNull())
    }

    override val context: CoroutineContext
        get() = kotlin.coroutines.EmptyCoroutineContext

}
