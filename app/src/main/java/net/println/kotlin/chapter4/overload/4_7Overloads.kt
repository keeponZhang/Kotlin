package net.println.kotlin.chapter4.overload

import java.util.ArrayList

/**
 * Created by benny on 4/4/17.
 */
class Overloads {
    @JvmOverloads //给java用
    fun a(int: Int = 0): Int {
        return int
    }

    fun b(int: Int = 0): Int {
        return int
    }

    //下面两个可以简写成上面
//    fun a(int: Int ): Int{
//        return int
//    }
//    fun a(): Int{
//        return 0
//    }


    fun a(str: String): Int {
        return str.length
    }
}

fun main(args: Array<String>) {
    val overloads = Overloads()
    //有默认参数可以什么都不传
    println(overloads.a())
    println(overloads.a(3))
    println(overloads.a("keepon"))
    println(overloads.b())


    val integerList = ArrayList<Int>()
    integerList.add(13)
    integerList.add(2)
    integerList.add(3)
    integerList.add(23)
    integerList.add(5)
    integerList.add(15)
    integerList.add(50)
    integerList.add(500)
    println(integerList)

    integerList.removeAt(1)
    integerList.remove(5)
    println(integerList)
}