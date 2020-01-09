package ch05.ex5_1_3_TheWithFunction2

//with 相当于第一个参数实例调用它的拓展方法
//这里返回的是最后一行的结果
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
    toString()
}

fun main(args: Array<String>) {
    println(alphabet())
}
