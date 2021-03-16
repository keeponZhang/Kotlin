package ch05.ex1_5_1_MemberReferences

import ch05.ex1_2_LambdasAndCollections.Person

fun salute() = println("Salute!")

fun main(args: Array<String>) {
    //引用顶层函数
    run(::salute)



//    注意， personsAgeFunction 是一个单参数函数（返回给定人的年龄），
//    而drnitrysAgeFunction 是一个零参数的函数（ 返回已经指定好的人的年龄）。
//    在Kotlin 1.1 之前， 你需要显式地写出lambda { p. age ｝，而不是使用绑定成员
//    引用p:: age
    val p = Person("keepon", 34)
    val personsAgeFunction = Person::age
    println(personsAgeFunction(p))
///使用绑定成员引用
    val dmitrysAgeFunction = p::age
    println(dmitrysAgeFunction())
}
