package com.blog.sili

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

/**
 * createBy	 keepon
 */
val grandfatherJob = SupervisorJob()

//创建一个Job，
val job = GlobalScope.launch(grandfatherJob) {

    //启动一个子协程
    val childJob = launch {

    }
    childJob.cancel()
}

