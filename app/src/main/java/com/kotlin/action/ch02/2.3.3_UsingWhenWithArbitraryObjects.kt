package ch02.ex3_3_UsingWhenWithArbitraryObjects

import ch02.colors.Color
import ch02.colors.Color.*

//在“when ”结构中使用任意对象
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")  //如果没有任何其他分支匹配这里就会执行
    }

fun main(args: Array<String>) {
    println(mix(BLUE, YELLOW))
}
