package com.example.servicetest

/**
 * createBy	 keepon
 */
class SimpleData2<T> {
    var data: T? = null
    fun get(): T? {
        return data
    }

    fun set(t: T?) {
        data = t
    }
}