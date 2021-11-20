package com.bennyhuo.kotlin.coroutinebasics.eg.lua

import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * createBy	 keepon
 */
//注意，这里有suspend，相当于main方法里面是一个block
suspend fun main() {
//    val coroutine = Coroutine<Unit, Int>(Dispatcher()) {
//        200
//    }
    //返回200时会调用completion的resumeWith
    val producer = Coroutine.create<Unit, Int>("生产者", Dispatcher()) { start ->
        0
        for (i in 0..3) {
            //1.2.执行这里，传入i，并且挂起这里，恢复1，此时result等于1
            log("send  $i 之前， 生产 准备调用yield")
            //yield的R是生产的值，设置传i
            yield(i)
            log("send  $i （挂起点被恢复） 之后")
        }
        200
    }

    val consumer = Coroutine.create<Int, Unit>("消费者", Dispatcher()) { param: Int ->
        log("start", param)
        for (i in 0..3) {
            //yield的R是生产的值，设置传Unit，因为消费者值接收
            //希望yield在括号里面调用，所以增加了CoroutineBody
            //3.2.挂起，恢复3,因为3不关心返回值，这里传了Unit
            log("receive $i 前 ")
            val value = yield(Unit)
            //3.3
            log("receive $i 后(挂起点被恢复)", value)
        }
    }

    while (producer.isActive && consumer.isActive) {
        //原来是2个循环调用resume
//        第一次会触发开始，然后挂起，这里跟kotlin1.2.51那边的例子又有点不一样，这里的resume是Coroutine里面的方法
        //result就是生产的值，这里是suspend方法，会返回两次，一次是挂起标志
        //1.调用这里，挂起
        // 第二轮，挂起这里，恢复3.3
        val result = producer.resume(Unit)
        //2
        log("挂起点被恢复，获得生产的 $result")
        //3，传入resume，挂起
        consumer.resume(result)
    }
}