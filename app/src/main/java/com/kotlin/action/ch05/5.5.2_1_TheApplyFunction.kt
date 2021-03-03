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

fun main(args: Array<String>) {
    println(alphabet())
    println(alphabet2())
}
