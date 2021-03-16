package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
//在下面的方法中，我们指定了分隔符、前缀和后缀三个参数，但是对于这个函数的使用者来说，
//如果不去看这些函数的声明，很难看出这些String类型的含义，这时候就可以使用 命名参数 的方法来调用，这有两点好处：
//增加函数的可读性
//以想要的顺序指定需要的参数


@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>, sep: String = ":", prefix: String = "[", postfix: String = "]"
) {
    val result = StringBuffer(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            println("index $index  element $element")
            result.append(sep)
        }
        result.append(element)
    }
    result.append(postfix)
    println(result)
}

fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3)
    joinToString(list, ",", "{", "}")
    joinToString(list, postfix = "}")
}