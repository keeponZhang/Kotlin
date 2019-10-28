package com.keepon.kotlin.chapter9

import java.beans.PropertyChangeListener
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * createBy	 keepon
 */
//在Kotlin标准库中，已经包含了类似于ObservableValue的类，因此我们不用手动去实现可观察的属性逻辑，下面我们重写Person类：


class Person4(
        val name: String, age: Int
) : ValueChangeAware() {

    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)

}

fun main(args: Array<String>) {
    val person = Person4("suihai", 20)
    person.addListener(
            //监听者打印出改变的属性名、原属性值和新的属性值。
            PropertyChangeListener { event ->
                println("${event.propertyName} " +
                        "changed from ${event.oldValue} to ${event.newValue}" )
            }
    )
    person.age = 18
}

















































