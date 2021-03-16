package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */

fun main(args: Array<String>) {
    val list = listOf(1, 2, 4)
    joinToString(list, ",", "{", "}")
    //如果使用常规的调用语法时，必须按照函数声明中定义的参数顺序来给定参数，可以省略的只有排在末尾的参数。
    joinToString(list, ":", "{")
    //我们使用命名参数，并在不改变函数定义的情况下，改变传入参数的顺序，也可以得到和上面相同的运行结果
//    如果在调用一个函数时，指明了一个参数的名称，那它之后的所有参数都要表明名称。
//    当调用Java函数时，不能使用命名参数。
    joinToString(list, prefix = "{", postfix = "}", sep = ",")
//    如果使用命名参数，可以省略中间的一些参数，也可以以你想要的任意顺序只给定你需要的参数，例如我们只修改前缀和后缀，分隔符仍然采用默认值：
    joinToString(list, prefix = "{", sep = "，")
}