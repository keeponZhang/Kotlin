package com.example.providertest

import kotlin.reflect.KProperty

class Delegate {

    var propValue: Any? = 22

    //  MyClass表明委托功能可以在什么类使用，  KProperty是一个属性操作类，可用于获取属性相关的值，
    //  在当前场景下用不着，但是必须在方法参数上进行声明，<*>表示你不知道或者不关心泛型的具体类型，只是为了通过语法编译而已
    operator fun getValue(myClass: MyClass, prop: KProperty<*>): Any? {
        return propValue
    }

//    operator fun setValue(myClass: MyClass, prop: KProperty<*>, value: Any?) {
//        propValue = value
//    }

}
