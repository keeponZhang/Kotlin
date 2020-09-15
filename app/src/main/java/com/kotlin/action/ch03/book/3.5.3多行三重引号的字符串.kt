package com.kotlin.action.ch03.book.多行三重引号的字符串

/**
 *createBy keepon
 */

//三重引号字符串的目的， 不仅在于避免转义字符，而且使它可以包含任何字符，
//包括换行符。另外，它提供了一种更简单的方法，从而可以简单地把包含换行符的
//文本嵌入到程序中。例如，可以用ASCII 码来画点东西：
fun main(args: Array<String>) {
    val price = """ $  99.9 """
    val ktlinLogo = """ | //
. |//
. |/\"""
    println(ktlinLogo.trimMargin("."))
    println(price)
}

