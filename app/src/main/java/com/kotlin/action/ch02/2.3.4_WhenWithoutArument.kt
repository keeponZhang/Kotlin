package ch02.ex3_4_WhenWithoutArument

import ch02.colors.Color
import ch02.colors.Color.*

fun mixOptimized(c1: Color, c2: Color) =
    //使用不带参数的“when ”
//  如果没有给when 表达式提供参数，分支条件就是任意的布尔表达式。
    when {
        (c1 == RED && c2 == YELLOW) ||
        (c1 == YELLOW && c2 == RED) ->
            ORANGE

        (c1 == YELLOW && c2 == BLUE) ||
        (c1 == BLUE && c2 == YELLOW) ->
            GREEN

        (c1 == BLUE && c2 == VIOLET) ||
        (c1 == VIOLET && c2 == BLUE) ->
            INDIGO

        else -> throw Exception("Dirty color")
    }

//如果没有给when 表达式提供参数，分支条件就是任意的布尔表达式。
//rnixOptirnized 函数和前面的mix 函数做的事情一样。这种写法的优点是不会创
//建额外的对象，但代价是它更难理解。


fun main(args: Array<String>) {
    println(mixOptimized(BLUE, YELLOW))
}
