package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */
//以joinToString函数为例，我们除了可以定义前缀、后缀和分隔符以外，
//还可以通过最后一个 函数类型的参数 指定如何将集合当中的每个元素转换成为String，
//这是一个泛型函数：它有一个类型参数T表示集合中的元素的类型，Lambda transform将接收这个类型的参数，
//下面我们来看一下如何为它指定一个lambda作为默认值：

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = "",
        //为函数类型的参数提供默认值。
        transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        //调用传入的函数。
        result.append(transform(element))
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase() })
    println(letters.joinToString(separator = "! ", postfix = "! ",
            transform = { it.toUpperCase() }))
}
















































