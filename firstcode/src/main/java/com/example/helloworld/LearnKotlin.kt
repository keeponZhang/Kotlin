package com.example.helloworld

fun main(args: Array<String>) {
//    val student = Student("Jack", 19)
//    doStudy(student)

//    val cellphone1 = Cellphone("Samsung", 1299.99)
//    val cellphone2 = Cellphone("Samsung", 1299.99)
//    println(cellphone1)
//    println("cellphone1 equals cellphone2 " + (cellphone1 == cellphone2))

//    Singleton.singletonTest()

//    val list = mutableListOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    list.add("Watermelon")
//    for (fruit in list) {
//        println(fruit)
//    }

//    val set = setOf("Apple", "Banana", "Orange", "Pear", "Grape")
//    for (fruit in set) {
//        println(fruit)
//    }


//    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
//    for ((fruit, number) in map) {
//        println("fruit is " + fruit + ", number is " + number)
//    }

//    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Watermelon")
//    val anyResult = list.any { it.length <= 5 }
//    val allResult = list.all { it.length <= 5 }

//    Thread {
//        println("Thread is running")
//    }.start()

//    doStudy(null)

//    val brand = "Samsung"
//    val price = 1299.99
//    println("Cellphone(brand=$brand, price=$price)")

//    printParams(str = "world")
}

var test: String = "test"

fun biggerValue(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

fun getScore(name: String) = when {
    name.startsWith("Tom") -> 86
    name == "Jim" -> 77
    name == "Jack" -> 95
    name == "Lily" -> 100
    name is CharSequence -> 111
    else -> 0
}

fun checkNumber(num: Number) {
    when (num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

fun getTextLength(text: String?) = text?.length ?: 0

var study: Study? = null

//注意这个block(this)
fun doStudy() {
    study?.let {
        it.readBooks()
        it.doHomework()
    }
}
//apply会返回调用者对象，用的也是拓展方法
//T.() -> Unit，相当于调用者内部调用这个lambda表达式，lambda表达式相当于一个内部方法，所以可以直接访问属性
fun alphabet() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet!")
}

//run方法返回的lambda表达式里面的
fun alphabet2() = StringBuilder().run {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet2!")
    println("")
}
fun printParams(num: Int = 100, str: String) {
    println("num is $num , str is $str")
}