package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//下面我们先定义一个泛型类Holder<T>，再将它的类型形参替换为具体类型Int：

interface Holder<T> {
    fun getValue() : T
    fun setValue(t : T)
}

class HolderInt : Holder<Int> {
    var a : Int = 0;
    override fun getValue() = a
    override fun setValue(value : Int) {
        a = value
    }
}

//fun main(args: Array<String>) {
//    val t = HolderInt()
//    t.setValue(2)
//    println("value=${t.getValue()}")
//}



































