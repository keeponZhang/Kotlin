package com.kotlin.action.ch02.book.可变变量和不可变量.kt

/**
 *createBy keepon
 */

//val 引用自身是不可变的，但是它指向的对象可能是可变的。例如，
//下面这段代码是完全有效的
//val languages = arrayListOf （"Java")
//languages.add ("Kotlin")

//var 关键字允许变量改变自己的值，但它的类型却是改变不了的。例如，
//下面这段代码是不会编译
//var answer = 42
//answer = ” no answer”