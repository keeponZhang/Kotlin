package ch06.ex2_1_PrimitiveTypes

import com.keepon.kotlin.chapter6.StringProcessor

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

fun main(args: Array<String>) {
    showProgress(146)
}

//当在kotlin中重写Java的方法时,可以选择把参数和返回类型定义成可空的，也可以选择把它们定义成非空的(字节码加了可空和不可空的字节码)
class StringPrinter(val name: String) : StringProcessor {
    override fun process(value: String) {
//        print(String)
    }
}

//Kotlin中实现接口时使用不同的可空性：
class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
//        println(value ?: "Empty")
    }
}