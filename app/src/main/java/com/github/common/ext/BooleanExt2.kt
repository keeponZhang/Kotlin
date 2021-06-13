package com.github.common.ext

/**
 * createBy	 keepon
 */

sealed class BooleanExt2<out T> {
    //Otherwise什么都不携带，可以传Nothing,Nothing是任意类的子类
    object Otherwise : BooleanExt2<Nothing>()

    //存在getData方法，T在out位置上
    class WithData<T>(val data: T) : BooleanExt2<T>()
}

inline fun <T> Boolean.yes2(block: () -> T): BooleanExt2<T> =
        when {
            //this 其实是调用者
            this -> {
                BooleanExt2.WithData(block())
            }
            else -> {
                BooleanExt2.Otherwise
            }
        }

//这里无论是Otherwise，WithData，都要T的志
inline fun <T> BooleanExt2<T>.otherwise2(block: () -> T): T =
        when (this) {
            is BooleanExt2.Otherwise -> block()
            is BooleanExt2.WithData -> this.data
        }

fun main(args: Array<String>) {
    val booleanExt = false.yes2 {
        //yes 前面是true 走这里
        println(" false.yes" + 1)
        1
    }.otherwise2 {
        //yes 前面是false 走这里
        println(" false.yes" + 2)
        2
    }

    val booleanExt2 = true.yes2 {
        //yes 前面是true 走这里
        println(" false.yes" + 1)
        1
    }.otherwise2 {
        //yes 前面是false 走这里
        println(" false.yes" + 2)
        2
    }

    val booleanExt3 = true.yes2 {
        //yes 前面是true 走这里
        "keepon7"
    }.otherwise2 {
        //yes 前面是false 走这里
        "keepon22"
    }
    println("$booleanExt  $booleanExt2  $booleanExt3")
}