package com.example.servicetest

/**
 * createBy	 keepon
 */
//意味着T只能出现在out位置，就返回位置，所以这里只能有get方法，并且data为val类型
class SimpleData<out T>(val data: T? = null) {
    fun get(): T? {
        return data
    }

//    fun set(t: T?) {
//        data = t
//    }
}