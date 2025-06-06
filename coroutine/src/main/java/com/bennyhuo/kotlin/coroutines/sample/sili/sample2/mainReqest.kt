package com.bennyhuo.kotlin.coroutines.sample.sili.sample2.request

import com.bennyhuo.kotlin.coroutines.sample.sili.sample2.RequestBuilder
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val result = RequestBuilder().buildRequest {
        // 这里的 `this` 是 RequestBuilder 实例，可以直接访问其成员
        url = "https://example.com"
        method = "POST"
        addHeader("Content-Type", "application/json")

        println("Configuring request: $url") // 访问 url 属性
    }
    println(result)
}