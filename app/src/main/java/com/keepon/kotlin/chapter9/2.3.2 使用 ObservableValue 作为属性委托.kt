package com.keepon.kotlin.chapter9

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * createBy	 keepon
 */
//在上面的代码中，如果Person类中包含了多个与age类似的属性，那么就需要创建多个_age的实例，
//并把getter和setter委托给它，Kotlin的委托属性可以让你摆脱这些样板代码，首先，我们需要重写ObservableValue代码，
//让它符合属性委托的约定。

class ObservableValue2 (
        var valueValue : Int,
        val changeSupport : PropertyChangeSupport
) {
    //按照约定的需要，用 operator 来标记，并添加了 KProperty。
    operator fun getValue(p : Person3, prop : KProperty<*>) : Int = valueValue
    operator fun setValue(p : Person3, prop : KProperty<*>, newValue : Int) {
        val oldValue = valueValue
        valueValue = newValue
        //通知监听者。
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

//和2.3.1相比，我们做了以下几点修改：
//
//按照约定的需要，getValue和setValue函数被标记了operator。
//这些函数加了两个参数：一个用于接收属性的实例，用来设置和读取属性，另一个用于表示属性本身，这个属性类型为KProperty，你可以使用KProperty.name的方式来访问该属性的名称
class Person3(val name : String, age : Int) : ValueChangeAware() {
    var age : Int by ObservableValue2(age, changeSupport)
}

fun main(args: Array<String>) {
    val person = Person3("keepon", 20)
    person.addListener(
            //监听者打印出改变的属性名、原属性值和新的属性值。
            PropertyChangeListener { event ->
                println("${event.propertyName} " +
                        "changed from ${event.oldValue} to ${event.newValue}" )
            }
    )
    person.age = 18
}




































































