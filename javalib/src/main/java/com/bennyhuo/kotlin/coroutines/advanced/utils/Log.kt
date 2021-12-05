package com.bennyhuo.kotlin.coroutines.advanced.utils

import java.text.SimpleDateFormat
import java.util.Date

val dateFormat = SimpleDateFormat("HH:mm:ss:SSS")

val now = {
    dateFormat.format(Date(System.currentTimeMillis()))
}

fun log(vararg msg: Any?) =
//    val classname = Exception().stackTrace[1].className
//    println("classname-------------$classname")
//        ${now()}
        println("[${Thread.currentThread().name}] ${diaoyongName()} ${msg
                .joinToString(" ")}")

fun stackTrace() {
    Throwable().printStackTrace(System.out)
}

fun diaoyongName(): String = Exception().stackTrace[2].let { it ->
    var fileName = it.fileName.subSequence(0, it.fileName.length - 2)
    val methodName = it.methodName
    " $fileName$methodName"
}


//fun <T> Continuation<T>.log(vararg msg: Any?) = context.log(*msg)
//
////
//fun CoroutineContext.log(vararg msg: Any?) =
//        println("${now()} [${Thread.currentThread().name} " +
//                "${this[Job]}  classname=${diaoyongName()}] ${msg.joinToString(" ")}")
