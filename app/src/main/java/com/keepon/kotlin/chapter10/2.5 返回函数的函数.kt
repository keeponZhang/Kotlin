package com.keepon.kotlin.chapter10

/**
 * createBy	 keepon
 */

//从函数中返回另一个函数适用于下面的场景：程序中的一段逻辑可能会因为程序的状态或者其他条件而产生变化，比如说下面的例子，运输费用的计算依赖于选择的运输方式：

//声明一个枚举类型。
enum class Delivery { STANDARD, EXPIRED }

class Order(val itemCount : Int)

//返回的函数类型为：形参为 Order 类，返回类型为 Double。
fun getShippingCalculator(delivery : Delivery) : (Order) -> Double {
    if (delivery == Delivery.EXPIRED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

fun main(args: Array<String>) {
    val calculator = getShippingCalculator(Delivery.EXPIRED)
    println("cost ${calculator(Order(3))}")


    val contacts = listOf(Person("Dmitry", "123-4567"),
            Person("Svelana", null))
    val contactListFilters = ContactListFilter()
    contactListFilters.prefix = "S"
    contactListFilters.onlyWithPhoneNumber = false
    println(contacts.filter(contactListFilters.getPredicate()))
}

//在上面的例子中，getShippingCalculator返回了一个函数，这个函数以Order作为参数并返回一个Double类型的值，要返回一个函数，
//需要写一个return表达式，跟上一个lambda、一个成员引用，或者其他的函数类型的表达式。

data class Person(val firstName : String, val phoneNumber : String?)

class ContactListFilter {
    var prefix : String = ""
    var onlyWithPhoneNumber : Boolean = false

    fun getPredicate() : (Person) -> Boolean {
        val startWithPrefix = { p : Person ->
            p.firstName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber) {
            return startWithPrefix
        }
        return { startWithPrefix(it) && it.phoneNumber != null }
    }
}








































