package ch03.JoinToStringFinal

//带有默认值
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
    val list = listOf(1, 2, 3)
    println(list.joinToString(separator = "; ",
        prefix = "(", postfix = ")"))
    //命名参数可以不按顺序
    println(list.joinToString(separator = ", ",
        postfix = ")", prefix = "("))
    //下面这个通不过编译如果在调用一个函数时，
    //指明了一个参数的名称，为了避免混淆，那它之后的所有参数都需要标明名称。
//    println(list.joinToString(separator = ", ",
//        postfix = ")", "("))
}


//不幸的是，当你调用Java的函数时，不能采用命名参数，不管是
//JDK 中的函数，或者是Android 框架的函数，都不行。把参数名称存到.class
//文件是Java8及其更高版本的一个可选功能，而Kotlin需要保持和Java6
//的兼容性。所以，编译器不能识别出调用函数的参数名称，然后把这些参
//数名对应到函数的定义的地方。
