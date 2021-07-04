package com.bennyhuo.kotlin.coroutines.advanced.channel

import com.bennyhuo.kotlin.coroutines.advanced.utils.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

suspend fun main() {
    basics()

//    broadcast()
}

suspend fun basics() {
//    这里用的是同一个channel
    val channel = Channel<Int>(Channel.RENDEZVOUS)
//    val channel = Channel<Int>(Channel.UNLIMITED)
//    val channel = Channel<Int>(Channel.CONFLATED)
//    val channel = Channel<Int>(Channel.BUFFERED)
//    val channel = Channel<Int>(1)

    val producer = GlobalScope.launch {
        for (i in 0..3) {
            log("sending", i)
            channel.send(i)
            log("sent", i)
        }
        channel.close()
    }

    val consumer = GlobalScope.launch {
        while (!channel.isClosedForReceive) {
            log("receiving")
            val value = channel.receiveOrNull()
            log("received", value)
        }
    }

    producer.join()
    consumer.join()
}

suspend fun iterateChannel() {
    val channel = Channel<Int>(Channel.UNLIMITED)

    val producer = GlobalScope.launch {
        for (i in 0..3) {
            log("sending", i)
            channel.send(i)
            log("sent", i)
        }
        channel.close()
    }

    val consumer = GlobalScope.launch {
//       与上面相比，这里可以用for 这里可以用for
        for (i in channel) {
            log("received: ", i)
        }
    }

    producer.join()
    consumer.join()
}

suspend fun producer() {
//    返回一个receiveChannel
    val receiveChannel = GlobalScope.produce(capacity = Channel.UNLIMITED) {
        for (i in 0..3) {
            log("sending", i)
//            里面send却是sendChannel，send也是挂起函数
            send(i)
            log("sent", i)
        }
    }

    val consumer = GlobalScope.launch {
//        遍历的是receiveChannel
        for (i in receiveChannel) {
            log("received: ", i)
        }
    }
//这join一次
    consumer.join()
}

suspend fun consumer() {
//    actor返回的是sendChannel
    val sendChannel = GlobalScope.actor<Int>(capacity = Channel.UNLIMITED) {
//        这里面的是receiveChannel
        for (i in this) {
            log("received: ", i)
        }
    }

    val producer = GlobalScope.launch {
        for (i in 0..3) {
            log("sending", i)
            sendChannel.send(i)
            log("sent", i)
        }
    }
//这里也join一次
    producer.join()
}

suspend fun broadcast() {
    //val broadcastChannel = BroadcastChannel<Int>(Channel.BUFFERED)

    val broadcastChannel = GlobalScope.broadcast {
        for (i in 0..5) {
            send(i)
        }
    }

    List(5) { index ->
        GlobalScope.launch {
            val receiveChannel = broadcastChannel.openSubscription()
            for (i in receiveChannel) {
                log("[#$index] received: $i")
            }
        }
    }.joinAll()
}

//调用close关闭channel
//关闭后调用send抛异常，isClosedForSend返回true
//关闭后调用receive可接收缓存的数据
//缓存消费完后receive抛异常，isClosedForReceive返回true