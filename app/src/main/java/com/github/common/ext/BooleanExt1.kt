package com.github.common.ext

/**
 * createBy	 keepon
 */

sealed class BooleanExt1 {
    object Otherwise : BooleanExt1()
    class WithData(val data: Any?) : BooleanExt1()
}

inline fun <T> Boolean.yes1(block: () -> T): BooleanExt1 =
        when {
            //this 其实是调用者
            this -> {
                BooleanExt1.WithData(block())
            }
            else -> {
                BooleanExt1.Otherwise
            }
        }

//这里无论是Otherwise，WithData，都要T的志
inline fun <T> BooleanExt1.otherwise1(block: () -> T): T =
        when (this) {
            is BooleanExt1.Otherwise -> block()
            is BooleanExt1.WithData -> this.data as T
        }

fun main(args: Array<String>) {
    val booleanExt = false.yes1 {
        //yes 前面是true 走这里
        println(" false.yes" + 1)
        1
    }.otherwise1 {
        //yes 前面是false 走这里
        println(" false.yes" + 2)
        2
    }


    val booleanExt2 = true.yes1 {
        //yes 前面是true 走这里
        println(" false.yes" + 1)
        1
    }.otherwise1 {
        //yes 前面是false 走这里
        println(" false.yes" + 2)
        2
    }

    val booleanExt3 = true.yes1 {
        //yes 前面是true 走这里
        "keepon"
    }.otherwise1 {
        //yes 前面是false 走这里
        "keepon2"
    }
    println("$booleanExt  $booleanExt2  $booleanExt3")
}