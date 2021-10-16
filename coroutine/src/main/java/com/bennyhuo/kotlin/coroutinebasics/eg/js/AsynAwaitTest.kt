package com.bennyhuo.kotlin.coroutinebasics.eg.js

import android.os.Handler
import android.os.Looper
import com.bennyhuo.kotlin.coroutinebasics.api.githubApi
import com.bennyhuo.kotlin.coroutinebasics.common.Dispatcher
import com.bennyhuo.kotlin.coroutinebasics.common.DispatcherContext
import com.bennyhuo.kotlin.coroutinebasics.utils.log

/**
 * createBy	 keepon
 */
fun main() {
    Looper.prepare()
    val handlerDispatcher = DispatcherContext(object : Dispatcher {
        val handler = Handler()
        override fun dispatch(block: () -> Unit) {
            handler.post(block)
        }
    })

    async(handlerDispatcher) {
//       这里的await跟原来async.await还是不一样的
        val user = await { githubApi.getUserCallback("bennyhuo") }
        log(user)
    }

    Looper.loop()
}