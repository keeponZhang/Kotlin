package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//下面，我们通过一个例子来演示，在集合当中寻找名为Alice的人，找到了就直接返回：

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

public  fun <T> Iterable<T>.forEach2(action: (T) -> Unit): Unit {
    var lambda2 = action;
    for (element in this) action(element)
}
public inline fun <T> Iterable<T>.forEach3(action: (T) -> Unit): Unit {
//    一个非内联函数可以把它的lambda保存在变量中，以便在函数返回以后可以继续使用
//    var lambda3 = action;
    for (element in this) action(element)
}

fun lookForAlice2(people: List<Person>) {
    people.forEach2 {
        if (it.name == "Alice") {
            println("lookForAlice2 Found !")
            //这里会报错，因为forEach2不是内联函数
//            return
        }
    }
    println("lookForAlice2 Alice is not found")
}

fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}

fun main(args: Array<String>) {
    lookForAlice(people)
    lookForAlice2(people)
}




//如果在lambda中使用return关键字，它会 从调用 lambda 的函数 中返回，并不只是 从 lambda 中返回，
//这样的return语句叫做 非局部返回，因为它从一个比包含return的代码块更大的代码块中返回了。
//
//需要注意的是，只有 以 lambda 作为参数的函数是内联函数 的时候才能从更外层的函数返回。
//在一个非内联的lambda中使用return表达式是不允许的，一个非内联函数可以把它的lambda保存在变量中，以便在函数返回以后可以继续使用，这个时候lambda想要去影响函数的返回已经太晚了。
//









































