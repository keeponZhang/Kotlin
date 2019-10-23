package com.keepon.kotlin.chapter4

import java.io.File

/**
 * createBy	 keepon
 */
//对象声明可以继承自类和接口，这通常在你使用的框架需要去实现一个接口，但是你的实现不包含任何状态的时候很有用。

object CaseInsensitiveFileComparator:Comparator<File>{
    //实现了comparator接口，重写了该接口的方法
    override fun compare(file1: File, file2: File): Int {
         return  file1.path.compareTo(file2.path)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare(File("/User"),File("/user")))

    val files = listOf(File("/B"), File("/A"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}











