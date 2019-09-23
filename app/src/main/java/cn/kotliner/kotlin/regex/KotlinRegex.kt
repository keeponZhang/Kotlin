package cn.kotliner.kotlin.regex

/**
 * Created by benny on 5/28/17.
 */
fun main(args: Array<String>) {
    val source = "Hello, This 020-23835211 my phone number: 010-12345678. "
    //里面字符不用转义 rawString
    val pattern = """.*(\d{3}-\d{8}).*"""

    Regex(pattern).findAll(source).toList().flatMap(MatchResult::groupValues).forEach(::println)

}