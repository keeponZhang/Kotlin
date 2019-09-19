package net.println.kotlin.chapter4.delegates

import kotlin.reflect.KProperty

/**
 * Created by benny on 4/4/17.
 */
class Delegates{
    //by后面这个lazy其实就是代理，要求代理对象有getValue方法
    val hello by lazy {
        "HelloWorld"
    }
     val x = X()
    val hello2 by x

    //用var修饰，是可读可写，需要getValue和setValue方法
    var hello3 by x
}

class X{
    private var value: String? = null

    //只代理string类型
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue: $thisRef -> ${property.name}")
        return value?: "null"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String){
        println("setValue, $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

fun main(args: Array<String>) {
    val delegates = Delegates()
    println(delegates.hello)
    println(delegates.hello2)
    println(delegates.hello3)
    delegates.hello3 = "value of hello3"
    // println(delegates.hello2)输出 value of hello3 因为hello2和hello3的代理对象是一个对象
    println(delegates.hello2)
    println(delegates.hello3)
}