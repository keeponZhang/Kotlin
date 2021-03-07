package com.example.fragmentbestpractice

import org.jetbrains.annotations.NotNull

//public static final int lettersCount(@NotNull String $receiver) {
//拓展函数就是接收一个该类型的参数
fun String.lettersCount(): Int {
    var count = 0
    substring(0)
    for (char in this) {
        if (char.isLetter()) {
            count++
        }
    }
    return count
}

//
operator fun String.times(n: Int) = this.repeat(n)

//拓展方法 (反编译看后，其实就是用静态方法)
//operator fun String.times(int: Int): String{
//    val stringBuilder = StringBuilder()
//    for(i in 0 until int){
//        //this 指代调用者
//        stringBuilder.append(this)
//    }
//    return stringBuilder.toString()
//}