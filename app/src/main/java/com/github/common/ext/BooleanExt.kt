package com.github.common.ext

/**
 * createBy	 keepon
 */

sealed class BooleanExt {
    object Otherwise : BooleanExt()
    class WithData : BooleanExt()
}

inline fun Boolean.yes(block: () -> Unit): BooleanExt =
        when {
            //this 其实是调用者
            this -> {
                block()
                BooleanExt.WithData()
            }
            else -> {
                BooleanExt.Otherwise
            }
        }

inline fun BooleanExt.otherwise(block: () -> Unit) =
        when (this) {
            is BooleanExt.Otherwise -> block()
            is BooleanExt.WithData -> Unit
        }

fun main(args: Array<String>) {
    //第一个返回的是BooleanExt类型,如果是BooleanExt.WithData()，yes里面的已经执行
    val booleanExt = false.yes {
        //yes 前面是true 走这里
        println(" false.yes" + 1)
        1
    }
    //BooleanExt类型，如果是Otherwise，就会走block里面的
    booleanExt.otherwise {
        //yes 前面是false 走这里
        println(" false.yes" + 2)
        2
    }
}