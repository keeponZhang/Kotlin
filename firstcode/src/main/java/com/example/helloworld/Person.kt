package com.example.helloworld

open class Person(val name: String, val age: Int) {

    fun eat() {
        println(name + " is eating. He is " + age + " years old.")
    }

    constructor(name: String) : this(name, 12) {
    }

    constructor() : this("2", 3) {
    }
}


//没有主构造函数，从构造函数可以不用调用主构造函数
open class Person2 {
    //
    constructor(name: String) {
    }

    constructor(age: Int) {
    }
}

open class Person3() {
    constructor(name: String) : this() {
    }
}

fun main(args: Array<String>) {
//    val psrson2 = Person2()
//    跟java一样，没有构造函数会有个默认的构造函数,Student4可以看出,但是如果是空参从构造函数的话，也要调用主构造函数
//    val psrson = Person()
    val psrson3 = Person3()
}