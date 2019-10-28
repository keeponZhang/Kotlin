package com.keepon.kotlin.chapter9

import kotlin.reflect.KProperty

/**
 * createBy	 keepon
 */


class Delegate {
    private var value: String? = null
    //'operator' modifier is inapplicable on this function: must have at least 2 value parameters
//    operator fun getValue():String{
//        return "keepon"
//    }

    //代理对象一定要有getValue方法
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef -> ${property.name}")
        return "keepon"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("setValue, $thisRef -> ${property.name} = $value")
        this.value = value
    }
}
class Foo {
    //val 只要求getValue方法
    val aa by Delegate()
    //var 既要求getValue方法，又要求setValue
    var bb by Delegate()
}


fun main(args: Array<String>) {
    val fol = Foo()
    println(fol.aa)
    fol.bb = "2"
    println(fol.bb)
}














