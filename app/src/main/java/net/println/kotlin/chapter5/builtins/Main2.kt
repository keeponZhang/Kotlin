package net.println.kotlin.chapter5.builtins

import java.io.BufferedReader
import java.io.FileReader

/**
 * Created by benny on 4/15/17.
 */
data class Person(val name: String, val age: Int) {
    fun work() {
        println("$name is working!!!")
    }
}

fun main(args: Array<String>) {


    var person = findPerson()
    println(person?.name)
    println(person?.age)

    //let会把调用者穿进去，这里会传入person对象
    //这里写了问号，lambda表达式里面的问号就不用写了
    findPerson()?.let { person ->
        println(person.name)
        println(person.age)
        person.work()
    }

    //apply会创建一个拓展函数，这里不用调用person.work，直接调用work就行
//    T.() -> Unit，相当于调用者内部调用这个lambda表达式，所以可以直接访问属性
    findPerson()?.apply {
        println(name)
        println(age)
        work()
    }
    //with是两个参数的 ,第一个参数不要传空
    with(findPerson2(), {
        println(name)
        work()
    })


    //可以(name,age) 等于一个data class 实例
    findPerson()?.let { (name, age) ->
        println(name)
        println(age)
    }
    var buffer = BufferedReader(FileReader("hello.txt"))
    with(buffer) {
        var line: String?
        while (true) {
            line = readLine() ?: break
            println("with  $line")
        }
        close()
    }

    BufferedReader(FileReader("hello.txt")).use {
        var line: String?
        while (true) {
            line = it.readLine() ?: break
            println("use $line")
        }
    }
}

fun findPerson(): Person? {
    return null
}

fun findPerson2(): Person {
    return Person("keepon", 22)
}
