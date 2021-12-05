package com.bennyhuo.kotlin.coroutines.advanced.flow

import com.bennyhuo.kotlin.coroutines.advanced.utils.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import kotlin.system.measureTimeMillis

/**
 * createBy	 keepon
 */
//https://blog.csdn.net/eclipsexys/article/details/120520647?spm=1001.2014.3001.5501

suspend fun main() {

//    create()
//    collcet()
//    launchIn()

//    flow {
//        for (i in 0..3) {
//            emit(i.toString())
//        }
//    }.last()
//    status()
//    map()

//    transform()

//    transformWhile()

//    map()
//    combine()
//    merge2()

//    flowOn()

    flowOn2()

    withTimeoutOrNull()
    同步非阻塞()

    异步非阻塞()



}

private suspend fun 异步非阻塞() {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.onStart {
        log("xys", "Start Flow in ${Thread.currentThread().name}")
    }.onEach {
        log("xys", "emit value---$it")
    }.flowOn(Dispatchers.IO).collect {
        log("xys", "Collect Flow in ${Thread.currentThread().name}")
        log("xys", "Result---$it")
    }
}

private suspend fun 同步非阻塞() {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.onStart {
        log("xys", "Start Flow in ${Thread.currentThread().name}")
    }.onEach {
        log("xys", "emit value---$it")
    }.collect {
        log("xys", "Result---$it")
    }
}

private fun withTimeoutOrNull() {
    MainScope().launch {
        withTimeoutOrNull(2500) {
            flow {
                for (i in 1..5) {
                    delay(1000)
                    emit(i)
                }
            }.collect {
                log("xys", "Flow: $it")
            }
        }
    }
}

private suspend fun flowOn2() {
    flow {
        for (i in 0..3) {
            log("xys", "Emit Flow in ${Thread.currentThread().name}")
            emit(i)
        }
    }.flowOn(Dispatchers.IO).map {
        log("xys", "Map Flow in ${Thread.currentThread().name}")
        it * it
    }.collect {
        log("xys", "Collect Flow in ${Thread.currentThread().name}")
        log("xys", "Result---$it")
    }
}

private suspend fun flowOn() {
    flow {
        for (i in 0..3) {
            log("xys", "Emit Flow in ${Thread.currentThread().name}")
            emit(i)
        }
    }.map {
        log("xys", "Map Flow in ${Thread.currentThread().name}")
        it * it
    }.flowOn(Dispatchers.IO).collect {
        log("xys", "Collect Flow in ${Thread.currentThread().name}")
        log("xys", "Result---$it")
    }
}

private suspend fun merge2() {
    val flow1 = flowOf(1, 2).onEach { delay(10) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(20) }
    listOf(flow1, flow2).merge().collect {
        log("xys", "Flow merge: $it")
    }
}

private suspend fun combine() {
    val flow1 = flowOf(1, 2).onEach { delay(10) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(20) }
    flow1.combine(flow2) { i, s -> i.toString() + s }.collect {
        log("xys", "Flow combine: $it")
    }
}

private suspend fun CoroutineScope.map() {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.filter { value ->
        value == 1
    }.collect {
        log("xys", "Result---$it")
    }
}

private fun transformWhile() {
//    flow {
//        for (i in 0..3) {
//            emit(i)
//        }
//    }.transformWhile { value ->
//        emit(value)
//        value == 1
//    }.collect {
//        log("xys", "Result---$it")
//    }
}

private suspend fun transform() {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.transform { value ->
        if (value == 1) {
            emit("!!!$value!!!")
        }
    }.collect {
        log("xys", "Result---$it")
    }
}

private fun map() {
    flow {
        for (i in 0..3) {
            emit(i)
        }
    }.map {
        it * it
    }
}

private fun status() {
    MainScope().launch {
        log("xys", "Coroutine in ${Thread.currentThread().name}")
        val time = measureTimeMillis {
            flow {
                for (i in 0..3) {
                    emit(i.toString())
                }
                throw Exception("Test")
            }.retryWhen { _, retryCount ->
                retryCount <= 3
            }.onStart {
                log("xys", "Start Flow in ${Thread.currentThread().name}")
            }.onEach {
                log("xys", "emit value---$it")
            }.onCompletion {
                log("xys", "Flow Complete")
            }.catch { error ->
                log("xys", "Flow Error $error")
            }.onCompletion { exception ->
                log("xys", "Result---$exception")
            }
                    .collect {
                        log("xys", "Result---$it")
                    }
        }
        log("xys", "Time---$time")
    }
}

private fun launchIn() {
    flow {
        for (i in 0..3) {
            log("xys", "emit value---$i")
            emit(i.toString())
        }
    }.launchIn(MainScope())
}

private suspend fun collcet() {
    GlobalScope.launch {
        val time = measureTimeMillis {
            flow {
                for (i in 0..3) {
                    log("xys", "emit value---$i")
                    emit(i.toString())
                }
            }.collect {
                log("xys", "Result---$it")
            }
        }
        log("xys", "Time---$time")
    }

    MainScope().launch {
        val time = measureTimeMillis {
            flow {
                for (i in 0..3) {
                    log("xys", "emit value---$i")
                    emit(i.toString())
                }
            }.collectIndexed { index, value ->
                log("xys", "Result in $index --- $value")
            }
        }
        log("xys", "Time---$time")
    }

    flowOf(1, 2, 3).collectLatest {
        delay(1)
        log("xys", "Result---$it")
    }
}

private fun create() {
    flow {
        for (i in 0..3) {
            emit(i.toString())
        }
    }
    flowOf(1, 2, 3)

    listOf(1, 2, 3).asFlow()
//    emptyFlow()
}