package com.bennyhuo.kotlin.coroutinebasics.eg.lua

import com.bennyhuo.kotlin.coroutinebasics.utils.log

/**
 * createBy	 keepon
 */
suspend fun main() {
//    val coroutine = Coroutine<Unit, Int>(Dispatcher()) {
//        200
//    }
    //返回200时会调用completion的resumeWith
    val producer = Coroutine.create<Unit, Int>("生产者") {
        100
        for (i in 0..3) {
            log("send", i)
            yield(i)
        }
        200
    }

    val consumer = Coroutine.create<Int, Unit>("消费者") { param: Int ->
        log("start", param)
        for (i in 0..3) {
            val value = yield(Unit)
            log("receive", value)
        }
    }

    while (producer.isActive && consumer.isActive) {
        //原来是2个循环调用resume
        val result = producer.resume(Unit)
        consumer.resume(result)
    }
}