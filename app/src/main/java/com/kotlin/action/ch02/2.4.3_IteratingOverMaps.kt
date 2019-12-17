package ch02.ex4_3_IteratingOverMaps

import java.util.TreeMap

fun main(args: Array<String>) {
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {  //．． 语法不仅可以创建数字区间，还可以创建字符区间。
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }



// for 循环允许展开迭代中的集合的元素（在这个例子中， 展开的是map 的键值对集合）。
    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
}
