package com.bennyhuo.kotlin.coroutines.advanced.flow

import com.bennyhuo.kotlin.coroutines.advanced.utils.log
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

fun sequences() {
    val ints = sequence {
//        不能使用调度器
        yield(1)
//        不能使用其他挂起函数
        //delay(100)
        yield(2)
        yield(3)
    }
}

suspend fun flow2() {
//    flow可以使用其他挂起函数
    val intFlow = flow {
        log("--1----")
        emit(1)
        delay(100)
        emit(2)
        emit(3)
    }

    val dispatcher =
            Executors.newSingleThreadExecutor { Thread(it, "MyThread").also { it.isDaemon = true } }
                    .asCoroutineDispatcher()
    GlobalScope.launch(dispatcher) {
        intFlow.flowOn(Dispatchers.IO)
//                调用collect
                .collect { log(it) }
    }.join()
}

suspend fun exception() {
    flow<Int> {
        emit(1)
        throw ArithmeticException("Div 0")
    }.catch { t: Throwable ->
        log("caught error: $t")
    }.onCompletion { t: Throwable? ->
        log("finally.")
    }.flowOn(Dispatchers.IO)
            .collect { log(it) }

//    flow { // bad!!!
//        try {
//            emit(1)
//            throw ArithmeticException("Div 0")
//        } catch (t: Throwable){
//            log("caught error: $t")
//        } finally {
//            log("finally.")
//        }
//    }
}

fun fromCollections() {
    listOf(1, 2, 3, 4).asFlow()
    setOf(1, 2, 3, 4).asFlow()
    flowOf(1, 2, 3, 4)
}

suspend fun fromChannel() {
    val channel = Channel<Int>()
    channel.consumeAsFlow()

//    flow { // bad!!
//        emit(1)
//        withContext(Dispatchers.IO){
//            emit(2)
//        }
//    }

    channelFlow { // good
        send(1)
        withContext(Dispatchers.IO) {
            send(2)
        }
    }
}

suspend fun backPressure() {
    flow {
        emit(1)
        delay(50)
        emit(2)
    }.collectLatest { value ->
        println("Collecting $value")
        delay(100) // Emulate work
        println("$value collected")
    }
}

fun rxjava() {
    Observable.create<Int> {
        it.onNext(1)
        it.onNext(2)
        it.onNext(3)
        it.onComplete()
    }.subscribeOn(Schedulers.io())
            .observeOn(Schedulers.from(
                    Executors.newSingleThreadExecutor { Thread(it, "MyThread-Rx") }))
            .subscribe {
                log(it)
            }
}

suspend fun main() {
//    backPressure()
//    flow0()
//    flow1()
    flow2()
}

private suspend fun flow0() {
//    [main]  Collect.emit 1
//    [kotlinx.coroutines.DefaultExecutor]  Collect.emit 2
//    [kotlinx.coroutines.DefaultExecutor]  Collect.emit 3
//    delay后切回来是DefaultExecutor
    val intFlow = flow {
        emit(1)
        delay(100)
        emit(2)
        emit(3)
    }
    intFlow
//                调用collect
            .collect { log(it) }
}

private suspend fun flow1() {
//    [main]  Collect.emit 1
//    [DefaultDispatcher-worker-1]  Collect.emit 2
//    [DefaultDispatcher-worker-1]  Collect.emit 3
    val intFlow = flow {
        log("----1-----")
        emit(1)
        delay(100)
        log("----2-----")
        emit(2)
        emit(3)
    }
    intFlow
//  delay会调度到Dispatchers.IO
            .flowOn(Dispatchers.IO)
            .collect { log(it) }
}