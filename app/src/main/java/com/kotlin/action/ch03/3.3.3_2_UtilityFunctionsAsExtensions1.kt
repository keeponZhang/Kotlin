package ch03.ex3_3_2_UtilityFunctionsAsExtensions1

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun main(args: Array<String>) {
    val list = arrayListOf(1, 2, 3)
    println(list.joinToString(" "))

    val list2 = arrayListOf(4, 5, 6)
    println(list2.joinToString(prefix = "("))
}

//当使用常规的调用语法时，必须按照函数声明中定义的参数顺序来给定参数，
//可以省略的只有排在末尾的参数。如果使用命名参数，可以省略中间的一些参数，
//也可以以你想要的任意顺序只给定你需要的参数：
