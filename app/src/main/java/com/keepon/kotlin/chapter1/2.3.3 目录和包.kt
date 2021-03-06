package com.keepon2.kotlin.chapter1

import com.keepon.kotlin.chapter2.Person

/**
 * createBy	 keepon
 */

//1 Kotlin中包的概念和Java类似，每个kotlin文件都能以一个package语句开头，而文件中定义的所有声明（类、函数及属性）都会被放到这个包中。
//2 如果其他文件定义的声明也有相同的包，这个文件可以直接使用它们；如果包不同，则需要导入它们，导入语句放在文件的最前面并使用import关键字。
//3 kotlin不区分导入的是类还是函数，而且，它允许使用import关键字导入任何种类的声明，可以直接导入顶层函数的名称，也可以在包名称后加上.*来导入特定包中定义的所有声明。
//4 在Java中，要把类放到和包结构相匹配的文件与目录结构中，而在kotlin中，可以把多个package声明不相同的类放在同一个文件夹中。
//
fun main(args: Array<String>) {
    testDiff14()
    //Person看出2的不同
    val pesron = Person("test3", false)
    pesron.testDiff3()
}










