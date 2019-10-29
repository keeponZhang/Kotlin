package net.println.kotlin.chapter2

/**
 * Created by benny on 2/26/17.
 */
//Char类型
//1字符对应java的character
//2 占两个字节，表示一个16位的unicode字符
//3.字符用单引号''引起来，例如'a','0' ,'\n'
val aChar: Char = '0'
val bChar: Char = '中'
val cChar: Char = '\u000f'

fun main(args: Array<String>) {
    println("aChar $aChar")
    println("bChar $bChar")
    println("cChar $cChar")
}
