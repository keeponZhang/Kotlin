package ch02.ex5_1_TryCatchAndFinally

import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader): Int? {  //明式地指定这个函数可能抛出的异常
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}


//和Java 最大的区别就是throws 子句没有出现在代码中：如果用Java 来写这
//个函数，你会显式地在函数声明后写上throws IOException o 你需要这样做的
//原因是JOException 是一个受检异常。在Java 中，这种异常必须显式地处理。必
//须声明你的函数能抛出的所有受检异常。如果调用另外一个函数，需要处理这个函
//数的受检异常，或者声明你的函数也能抛出这些异常。
//和其他许多现代NM 语言一样， Kotlin 并不区分受检异常和未受检异常。不用
//指定函数抛出的异常， 而且可以处理也可以不处理异常。这种设计是基于Java 中使
//用异常的实践做出的决定。经验显示这些Java 规则常常导致许多毫无意义的重新抛
//出或者忽略异常的代码，而且这些规则不能总是保护你免受可能发生的错误。
//例如，在代码清单2 .27 中， NumberFormatExceptio 口就不是受检异常。因
//此， Java 编译器并不会强迫你捕获它，在运行时很容易看到这个异常发生。这很
//令人沮丧，因为无效的输入数据是常见的情况，应该能被优雅地处理。与此同时，
//BufferedReader.close 可能抛出需要处理的受检异常IOException 。如果流
//关闭失败，大多数程序都不会采取什么有意义的行动，所以捕获来自close 方法
//的异常所需的代码就是冗余的样板代码。