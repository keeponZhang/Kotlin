package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//HolderWrapper定义了它自己的类型参数T并把它指定为父类的类型参数，它是全新的类型形参，不必保留一样的名称：

interface HolderWrapper<T> : Holder<T>

class HolderInt2 : HolderWrapper<Int> {
    var a : Int = 0;
    override fun getValue() = a
    override fun setValue(value : Int) {
        a = value
    }
}

















