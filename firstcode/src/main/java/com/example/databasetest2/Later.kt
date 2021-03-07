package com.example.databasetest2

import kotlin.reflect.KProperty

class Later<T>(val block: () -> T) {

    var value: Any? = null

    //这里getVaule是返回一个对象，这里直接返回T
    operator fun getValue(any: Any?, prop: KProperty<*>): T {
        if (value == null) {
            value = block()
        }
        return value as T
    }
}

//by 才是关键字，lazy{}其实就是高阶函数，返回一个对象
val p by lazy { }

//lazy的原理，输入一个无参数的lambda表达式，返回一个对象
fun <T> later(block: () -> T) = Later(block)