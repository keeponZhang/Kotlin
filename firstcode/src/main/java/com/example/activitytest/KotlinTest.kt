package com.example.activitytest

import android.app.Activity

/**
 * createBy	 keepon
 */
fun main(args: Array<String>) {
//    ActivityBox.addActivity(Activity())
    //其实都是调用内部类实例的方法
    Util().doAction1()
    Util.doAction2()
    Util.doAction3()
    Util.keepon

    with()
    run()
    apply()
}

private fun with() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = with(StringBuilder()) {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
    println(result)
}

private fun run() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    //return block()
    val result = StringBuilder().run {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
}

//return this
private fun apply() {
    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")
    val result = StringBuilder().apply {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
        toString()
    }
}

