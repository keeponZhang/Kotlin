package ch02.ex3_2_1_WhenEnums


//Kotlin 用了enum class 两个关键字，而Java 只有enum 一个关键字。Kotlin 中， enum 是一个所谓
//的软关键字：只有当它出现在c lass 前面时才有特殊的意义，在其他地方可以把它当作普通的名称使用

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//和if 相似， when 是一个有返回值的表达式，因此可以写一个直接返回when
//表示式的表达式体函数。
fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"  //和Java 不一样，你不需要在每个分支都写上break语句,
        Color.ORANGE -> "Of"    //也可以把多个值合并到同一个分支，只需要用 逗号隔开这些值。
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun main(args: Array<String>) {
    println(getMnemonic(Color.BLUE))
}
