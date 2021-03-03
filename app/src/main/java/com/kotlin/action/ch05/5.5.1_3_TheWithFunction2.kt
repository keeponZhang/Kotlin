package ch05.ex5_1_3_TheWithFunction2

import com.keepon.kotlin.chapter6.sendEmailTo

//with 相当于第一个参数实例调用它的拓展方法(所以lambada表达式里面可以直接调用StringBuilder()的方法)
//这里返回的是最后一行的结果
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

//let是
fun let() {
    val nullEmail = "keepon"
    nullEmail?.let { it -> sendEmailTo(it) }
}

fun main(args: Array<String>) {
    println(alphabet())
}
