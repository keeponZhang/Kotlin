package com.example.jetpacktest.viewmodel

/**
 *createBy keepon
 */
object RetrofitClient {
    fun getXXX(i: Int): Response {
        return Response(true)
    }
}

class Response(val isSuccess: Boolean, val data: Any = "") {

}