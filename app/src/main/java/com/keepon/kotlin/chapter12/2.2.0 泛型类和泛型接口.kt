package com.keepon.kotlin.chapter12

/**
 * createBy	 keepon
 */
//Kotlin通过在类名称后加上一对尖括号，并把类型参数放在尖括号内来声明泛型类和泛型接口。一旦声明后，就可以在类型的主体内 像其它类型一样使用类型参数，例如List<T>：

interface List2<T> {
    operator fun get(index : Int) : T
}
//如果你的类继承了泛型类，或者实现了泛型接口，就得 为基础类型的泛型形参提供一个类型实参，它可以是一个 具体类型或者是另一个类型形参。


















