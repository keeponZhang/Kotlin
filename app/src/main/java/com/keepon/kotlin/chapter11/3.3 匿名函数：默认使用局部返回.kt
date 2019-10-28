package com.keepon.kotlin.chapter11

/**
 * createBy	 keepon
 */
//匿名函数是一种不同的用于编写传递给函数的代码块的方式，先来看一个示例：


fun lookForAlice4(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice") return
        println("${person.name} is not Alice")
    })
}

fun main(args: Array<String>) {
    lookForAlice4(people)
}



//匿名函数和普通函数有相同的指定返回值类型的规则，代码块匿名函数 需要显示地指定返回类型，如果使用 表达式函数体，就可以省略返回类型。
//
//在匿名函数中，不带return表达式会从匿名函数返回，而不是从包含匿名函数的函数返回，这条规则很简单：return从最近的使用fun关键字声明的函数返回。
//
//lambda表达式没有使用fun关键字，所以lambda中的return从最外层的函数返回。
//匿名函数使用了fun，因此return表达式从匿名函数返回。
//尽管匿名函数看起来和普通函数很相似，但它其实是lambda表达式的另一种语法形式而已。关于lambda表达式如何实现，以及在内联函数中如何被内联的讨论同样适用于匿名函数。



















































