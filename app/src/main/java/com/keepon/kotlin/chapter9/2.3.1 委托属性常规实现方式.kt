package com.keepon.kotlin.chapter9

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 * createBy	 keepon
 */

//要了解委托属性的实现方式，让我们来看另一个例子：当一个对象的属性更改时通知监听器。
//Java具有用于此类通知的标准机制：PropertyChangeSupport和PropertyChangeEvent。PropertyChangeSupport类维护了一个监听器列表，
//并向它们发送PropertyChangeEvent事件，要使用它，你通常需要把PropertyChangeSupport的一个实例存储为bean类的一个字段，
//并将属性更改的处理委托给它。
//
//为了避免在每个类中去添加这个字段，你需要创建一个小的工具类，用来存储PropertyChangeSupport的实例并监听属性更改，
//之后，你的类会继承这个工具类，以访问changeSupport。

open class ValueChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)
    //添加监听者。
    fun addListener(listener : PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }
    //移除监听者。
    fun removeListener(listener : PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

//辅助类，如果通过该辅助类改变了属性，那么将会通知监听者。
class ObservableValue (
        val valueName : String, var valueValue : Int,
        val changeSupport : PropertyChangeSupport
) {
    fun getValue() : Int = valueValue
    fun setValue(newValue : Int) {
        val oldValue = valueValue
        valueValue = newValue
        //通知监听者。
        changeSupport.firePropertyChange(valueName, oldValue, newValue)
    }
}

class Person2(val name : String, age : Int) : ValueChangeAware() {
    // _age 为辅助类的一个实例。
    val _age = ObservableValue("age", age, changeSupport)
    //通过辅助类进行读写操作。
    var age : Int
        get() = _age.getValue()
        set(value) { _age.setValue(value) }
}

fun main(args: Array<String>) {
    val person = Person2("zemao", 20)
    person.addListener(
            //监听者打印出改变的属性名、原属性值和新的属性值。
            PropertyChangeListener { event ->
                println("${event.propertyName} " +
                        "changed from ${event.oldValue} to ${event.newValue}" )
            }
    )
    person.age = 18
}


















































