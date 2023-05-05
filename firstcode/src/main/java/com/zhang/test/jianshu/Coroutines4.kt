package com.zhang.test.jianshu

import com.bennyhuo.kotlin.coroutines.utils.log
import com.zhang.test.jianshu.bean.Item
import com.zhang.test.jianshu.bean.Post
import com.zhang.test.jianshu.bean.Token
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
//https://www.jianshu.com/p/2659bbe0df16


suspend fun postItem4(item: Item) {
    val launch = GlobalScope.launch {
        async {
            requestToken()
        }.await()
    }
    launch.join()
}


