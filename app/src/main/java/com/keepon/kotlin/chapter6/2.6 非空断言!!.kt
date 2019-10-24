package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */

//非空断言 是Kotlin提供给你的最简单直率的处理可空类型的工具，它使用!!表示，可以把任何值转换成非空类型，如果对null值做非空断言，则会抛出异常，例如下面的示例代码：
fun  ignoreNulls(s:String ?){
    //这样会报错，因为右边的可能为空
//    val  isNotNull :String  = s?.substring(0)
    //可以改成这样
    val  isNotNull2 :String  = s?.substring(0)?:"default"
    println("isNotNull2 $isNotNull2")
    //还可以改成这样,其实这样是有风险的
//    val  isNotNull3 :String  = s!!.substring(0)
}

fun main(args: Array<String>) {
    ignoreNulls(null)
}