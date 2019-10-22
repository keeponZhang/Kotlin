package com.keepon.kotlin.chapter1

import java.io.BufferedReader
import java.io.StringReader

/**
 * createBy	 keepon
 */
//kotlin的异常处理和Java以及其他许多语言的处理方式类似：一个函数可以正常结束，也可以在出现错误的情况下抛出异常。方法的调用者能捕获到这个异常并处理它；如果没有处理，异常会沿着调用栈再次抛出。
//抛出异常时使用throw关键字，但是不必使用new关键字来创建异常实例。
//throw结构是一个表达式，能作为另一个表达式的一部分使用。

//当使用带有catch和finally子句的try结构来处理异常时，下面是一个典型的结构：

fun readNumber(reader:BufferedReader):Int?{
   try {
       val line  = reader.readLine()
       return Integer.parseInt(line)
   }catch (e:Exception){
       return null
   }finally {
       reader.close()
   }
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("222"))
    println(readNumber(reader))
}


//和Java最大区别就是throws子句没有出现在代码中：如果使用Java来写这个函数，
//你会显示地在函数声明上面写上throws IOException。这是因为IOException是一个受检异常，在Java中，这种异常必须显示地处理，必须声明你的函数能抛出所有的受检异常。作者：泽毛

//kotlin不区分受检异常和未受检异常，不必指定函数抛出的异常，而且可以处理也可以不处理异常。
//与此同时，BufferReader.close可能抛出需要处理的受检异常，如果关闭失败，大多数程序不会采取什么有意义的行动，所以捕获来自close方法的异常所需的代码是多余的。



