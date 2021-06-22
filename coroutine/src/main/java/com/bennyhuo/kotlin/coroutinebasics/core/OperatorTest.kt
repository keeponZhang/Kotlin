package com.bennyhuo.kotlin.coroutinebasics.core

import android.util.Log

/**
 * createBy	 keepon
 */
enum class OperatorTest {

    TEST;

    operator fun invoke(data: String) {
        Log.d("LogUtils", "data : $data")
    }
}

fun execute() {
    val start = OperatorTest.TEST
    //原始调用方式
    start.invoke("测试1")
    //简化调用方式
    start("测试2")
}