package net.println.kotlin.chapter4.delegates

import kotlin.reflect.KProperty

/**
 * Created by benny on 4/4/17.
 */
class Delegates {
    //by后面这个lazy其实就是代理，要求代理对象有getValue方法
    //lazy代理只覆写了getValue方法，所以这里不能用var
    //public inline operator fun <T> Lazy<T>.getValue(thisRef: Any?, property: KProperty<*>): T = value
    val hello by lazy {
        "HelloWorld"
    }
    val x = X()
    val y = Y()

//    val hello1 by y
    val hello2 by x

    //用var修饰，是可读可写，需要getValue和setValue方法
    var hello3 by x
}

class X {
    private var value: String? = null

    //只代理string类型
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        //thisRef 被代理的属性的拥有者
        println("getValue: $thisRef -> ${property.name}")
        return value ?: "null"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue, $thisRef -> ${property.name} = $value")
        this.value = value
    }
}

internal object UNINITIALIZED_VALUE

class Y {
    @Volatile
    private var _value: Any? = UNINITIALIZED_VALUE
    val value: String
        get() {
            val _v1 = _value
            if (_v1 !== UNINITIALIZED_VALUE) {
                @Suppress("UNCHECKED_CAST")
                return _v1 as String
            }

            return synchronized("lock") {
                val _v2 = _value
                if (_v2 !== UNINITIALIZED_VALUE) {
                    @Suppress("UNCHECKED_CAST") (_v2 as String)
                } else {
                    val typedValue = "Keepon"
                    _value = typedValue
                    typedValue
                }
            }
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