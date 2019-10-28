package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//一个类甚至可以把它自己作为类型实参引用，实现Comparable接口的类就是这种模式的经典例子，任何可以比较的元素都必须定义它如何与同样类型的对象比较。

interface Comparable<T> {
    fun compareTo(other : T) : Int
}

class String : Comparable<String> {
    override fun compareTo(other : String) : Int {
        return 1
    }
}
















