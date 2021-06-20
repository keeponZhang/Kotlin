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
        for (i in 0..3) {
            log("send 生产 $i  准备调用yield")
            //yield的R是生产的值，设置传i
            yield(i)
        }
        200
    }

    val consumer = Coroutine.create<Int, Unit>("消费者") { param: Int ->
        log("start", param)
        for (i in 0..3) {
            //yield的R是生产的值，设置传Unit，因为消费者值接收
            //希望yield在括号里面调用，所以增加了CoroutineBody
            val value = yield(Unit)
            log("receive", value)
        }
    }

    while (producer.isActive && consumer.isActive) {
        //原来是2个循环调用resume
//        第一次会触发开始，然后挂起
        val result = producer.resume(Unit)
        log("挂起点被恢复")
        consumer.resume(result)
    }
}