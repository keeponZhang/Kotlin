package com.example.fragmentbestpractice

/**
 * createBy	 keepon
 */
fun main(args: Array<String>) {
//    StringKt.lettersCount("abc");
    val count = "abc".lettersCount()
    val money1 = Money(5)
    val money2 = Money(10)
    val money3 = money1 + money2
    val money4 = money3 + 20
    println(money3.value)

    if ("heelo".contains("b")) {
        "3"
    }
    if ("c" in "keepon") "4"

    (1..20)
}