package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */

//使用in运算符来检查一个值是否在区间中，或者它的逆运算!in来检查这个值是否不在区间中，
//区间不仅限于字符，假如有一个支持实例比较操作的任意类（实现了java.lang.Comparable接口），就能创建这种类型的对象的区间。作者：泽毛

fun isLetter(c:Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNoDigit(c:Char) = c !in '0'..'9'


fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNoDigit('x'))
}












