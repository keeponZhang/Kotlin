package com.bennyhuo.kotlin.advancedtypes.eg

sealed class IntList {
//  最后一位如果没有
    object Nil: IntList() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons(val head: Int, val tail: IntList): IntList(){
        override fun toString(): String {
//            这里有递归调用，tail也会调用toString
            return "$head, $tail"
        }
    }

    fun joinToString(sep: Char = ','): String {
        return when(this){
            Nil -> "Nil"
            is Cons -> {
                "${head}$sep${tail.joinToString(sep)}"
            }
        }
    }
}

fun IntList.sum(): Int {
    return when(this){
        IntList.Nil -> 0
        is IntList.Cons -> head + tail.sum()
    }
}

operator fun IntList.component1(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> head
    }
}

operator fun IntList.component2(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> tail.component1()
    }
}

operator fun IntList.component3(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> tail.component2()
    }
}

fun intListOf(vararg ints: Int): IntList {
    return when(ints.size){
        0 -> IntList.Nil
        else -> {
            IntList.Cons(
                ints[0],
//                    切出来一个数组
                intListOf(*(ints.slice(1 until ints.size).toIntArray()))
            )
        }
    }
}

// [0, 1, 2, 3]
fun main() {
    //最后一位没了，所以用IntList.Nil
    val list0 = IntList.Cons(0, IntList.Cons(1,  IntList.Cons(2,  IntList.Cons(3, IntList.Nil))))
    val list = intListOf(0, 1, 2, 3)
//    println(list)
//    println(list.joinToString('-'))
    println(list.sum())

    val (first, second, third) = list
//
//    println(first)
//    println(second)
//    println(third)

    //val (a, b, c, d, e) = listOf<Int>()
}