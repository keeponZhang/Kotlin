package com.bennyhuo.kotlin.coroutines.sample.sili.sample2

import kotlinx.coroutines.delay


class RequestBuilder {
    var url: String = ""
    var method: String = "GET"
    var headers: MutableMap<String, String> = mutableMapOf()

    fun addHeader(key: String, value: String) {
        headers[key] = value
    }
    suspend fun buildRequest(block: suspend RequestBuilder.() -> Unit): String {
        block() // 这里会执行传入的 lambda，且 lambda 的 `this` 是当前的 RequestBuilder 实例
        return execute()
    }
    suspend fun execute(): String {
        delay(1000) // 模拟网络请求
        return "Response from $method $url"
    }
}