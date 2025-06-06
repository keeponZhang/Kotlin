package com.bennyhuo.kotlin.coroutines.sample.sili.sample2.scope

import kotlinx.coroutines.delay

class MyScope {
    val name: String = "MyScope"

    suspend fun doWork() {
        delay(500)
        println("Work done in $name")
    }
}