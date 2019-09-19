package net.println.kotlin.chapter4

import net.println.kotlin.chapter4.objects.MusicPlayer

/**
 * Created by benny on 4/3/17.
 */
//open val age age也可以被覆写
abstract class Person(open val age: Int){
    abstract fun work()
}

class MaNong(age: Int): Person(age){

    override val age: Int
        get() = 21
//        get() {
//        return 0 ;
//    }

    //覆写方法，override必须有
    override fun work() {
        println("我是码农，我在写代码")
    }
}

class Doctor(age: Int): Person(age){
    override fun work() {
        println("我是医生，我在给病人看病")
    }
}

fun main(args: Array<String>) {
    val person: Person = MaNong(23)
    person.work()
    println(person.age)

    val person2 : Person = Doctor(24)
    person2.work()
    println(person2.age)


}