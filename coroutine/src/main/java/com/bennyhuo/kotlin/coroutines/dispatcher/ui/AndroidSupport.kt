package com.bennyhuo.kotlin.coroutines.dispatcher.ui

import android.os.Handler
import android.os.Looper
import com.bennyhuo.kotlin.coroutines.dispatcher.Dispatcher
import com.bennyhuo.kotlin.coroutines.utils.log

object HandlerDispatcher: Dispatcher {
    private val handler = Handler(Looper.getMainLooper())

    override fun dispatch(block: () -> Unit) {
        log("---------------------------------")
        handler.post(block)
    }
}