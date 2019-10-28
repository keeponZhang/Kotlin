package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//也可以在lambda表达式中使用局部返回，类似于for循环中的break表达式，它会终止lambda的执行，
//并接着从调用lambda的代码处执行。

//要区分局部返回和非局部返回，要用到标签。想从一个lambda表达式处返回你可以标记它，
//然后在return关键字后面引用这个标签。



fun lookForAlice3(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice"){
            println("found!")
            //其实相当于for循环的break作用
            return@label
        }
    }
    println("Alice might be somewhere")
}

fun main(args: Array<String>) {
    lookForAlice3(people)
}





































