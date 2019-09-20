package net.println.kotlin.chapter5.builtins

/**
 * Created by benny on 4/15/17.
 */

data class Person(val name: String, val age: Int){
    fun work(){
        println("$name is working!!!")
    }
}

fun main(args: Array<String>) {
//    BufferedReader(FileReader("hello.txt")).use {
//        var line: String?
//        while (true){
//            line = it.readLine()?: break
//            println(line)
//        }
//    }

    val list = listOf(1,2,4,6)
//    var newlist = ArrayList<Int>()
//    list.forEach{
//        val  newElement = it*2
//        newlist.add(newElement)
//    }


    //返回值加到list集合
    var newlist = list.map {
        println("map 功能测试")
        it*2
    }


    newlist.forEach {
        println("new list element $it")
    }
}

fun findPerson(): Person?{
    return null
}