package ch02.ex4_4_2_UsingAnInCheck1

//in 运算符和！ in 也适用于when 表达式。
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun main(args: Array<String>) {
    println(recognize('8'))
    println(" Kotlin" in "Java ".." Scala")
//    结果和 Java<=Kotlin  &&Kotlin<=Scala 一样

    println("Kotlin" in setOf("Java ", "Scala", "Kotlin"))
}
