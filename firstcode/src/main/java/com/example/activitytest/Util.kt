package com.example.activitytest

import com.bennyhuo.kotlin.coroutines.utils.log

/**
 * @author guolin
 * @since 2019-05-14
 */

class Util {

    fun doAction1() {
        println("do action1")
    }

    //companion object属性会生成静态的外部属性，公共的(companion object跟object生成的是不一样的)
    companion object {
        //属性会生成静态的外部属性,私有的，然后静态内部类里面生成方法
        val keepon = "keepon"

        //私有的是不会生成方法的，但同样会在外部类生成属性
        private val keepon2 = "keepon2"
        val interfaceImpl = object : Runnable {
            override fun run() {
                println("" + keepon2)
            }
        }

        @JvmStatic
        fun doAction2() {
            println("do action2")
        }

        fun doAction3() {
            println("do action3")
        }
    }
}

class Util2 {
    //companion object属性会生成静态的外部属性，公共的(companion object跟object生成的是不一样的)
    companion object : Runnable {
        override fun run() {
            log("test")
        }
    }
}

fun main(args: Array<String>) {
    test2 { str -> str + 1 }
//    其实就是调用Util2的静态属性，然后调用方法
    Util2.run()
}

fun test2(block: (String) -> String) {
    block("3")
}