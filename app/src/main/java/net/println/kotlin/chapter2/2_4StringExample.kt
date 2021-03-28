package net.println.kotlin.chapter2

/**
 * Created by benny on 2/26/17.
 */
val string: String = "HelloWorld"
//字符串可以用字符去构造
val fromChars: String = String(charArrayOf('H', 'e','l','l','o','W','o','r','l','d'))

fun main(args: Array<String>) {
    // kotlin == 与equals完全等价
    println("string == fromChars "+(string == fromChars))
    //三个等号 === 相等于java的==
    println("三个等号string === fromChars "+(string === fromChars))

    println("接下来我们要输出:" + string)

    val arg1: Int = 0
    val arg2: Int = 1
    println("" + arg1 + " + " + arg2 + " = " + (arg1 + arg2))
    println("$arg1 + $arg2 = ${arg1 + arg2}")

    //Hello "Trump"
    //转义字符\"
    val sayHello : String = "Hello \"Trump\""
    println(sayHello)
    //salary
    val salary: Int = 1000
    //$salary 转义字符\$
    println("\$salary")

    //""" """ 保持格式
    val rawString: String = """
        \t
        \n
\\\\\\$$$ salary
    """
    println(rawString)
    println(rawString.length)
}