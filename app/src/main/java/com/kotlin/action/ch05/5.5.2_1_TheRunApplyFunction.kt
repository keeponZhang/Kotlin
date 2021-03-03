package ch05.ex5_2_1_TheApplyFunction

//apply会返回调用者对象，用的也是拓展方法
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}.reverse()

//run方法返回的lambda表达式里面的
fun alphabet2() = StringBuilder().run {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet2!")
    println("")
}.toString()

//apply返回this，run是返回block里面的
fun alphabet3() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet2!")
    println("")
}.toString()

fun alphabet4() = StringBuilder().run2 {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet2!")
    println("")
}.toString()
//注意，lambda表达式也是一种参数类型
//T.不能省略，表示是T的拓展函数，那他里面自然就可以调用T的方法，不然那只是普通的lambda表达式
public inline fun <T, R> T.run2(block: T.() -> R): R {
    return block()
}

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabet2())
}
