package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//在Java中，和when类似的switch语句要求必须使用常量（枚举常量、字符串或者数字字面值）作为 分支条件，而when允许使用任何对象，我们使用一个函数来混合两种颜色。下面例子中用到的setOf是由Kotlin标准函数库提供的，
//它可以创建出一个Set，并且会包含所有指定为函数实参的对象，只要两个set中包含一样的条目，它们就是相等的，集合的条目顺序并不重要。作者：泽毛
//
fun mix(c1: Color, c2: Color) =
    when (linkedSetOf(c1, c2)) {
        linkedSetOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        linkedSetOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        linkedSetOf(Color.BLUE, Color.VIOLET) -> Color.INGIGO
        else -> throw Exception("Dirty color")
    }

fun mix2(c1: Color, c2: Color) =
    when (linkedSetOf(c1, c2)) {
        linkedSetOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        linkedSetOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        linkedSetOf(Color.BLUE, Color.VIOLET) -> Color.INGIGO
        else -> throw Exception("Dirty color")
    }

fun main(args: Array<String>) {
    println(mix(Color.BLUE, Color.VIOLET))
}


