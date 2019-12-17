package ch02.ex5_2_1_TryAsAnExpression

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    }

    println(number)
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)
    val reader2 = BufferedReader(StringReader("222"))
    readNumber(reader2)
}


//Kotlin 中的try 关键字就像if 和when 一样，引入了一个表达式，可以把它
//的值赋给一个变量。不同于if，你总是需要用花括号把语句主体括起来。和其他语
//句一样，如果其主体包含多个表达式，那么整个try 表达式的值就是最后一个表达
//式的值。
//这个例子将return 语句放在catch 代码块中，因此该函数的执行在catch
//代码块之后不会继续。如果你想继续执行， catch 子句也需要有一个值， 它将是子
//句中最后一个表达式的值。下面展示了这是怎么回事。