package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */


class StringPrinter (val name:String): StringProcessor {
    override fun process(value: String) {
        print(String)
    }
}
//Kotlin中实现接口时使用不同的可空性：
class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        println(value ?: "Empty")
    }
}

fun main(args: Array<String>) {
    val stringPrinter = StringPrinter("ee")
    //这个会报错
//    stringPrinter.process(null)

    val nullableStringPrinter = NullableStringPrinter()
    //这个不会报错
    nullableStringPrinter.process(null)
}