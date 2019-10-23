package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */

//在类中使用对象声明时，这样的对象同样只有一个单一实例：它们在每个容器类的实例中具有相同的实例
data class Person2(val name:String){
    object NameComparator:Comparator<Person2>{
        override fun compare(o1: Person2, o2: Person2): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

fun main(args: Array<String>) {
    val persons = listOf(Person2("Bob"), Person2("Alice"))
    println(persons.sortedWith(Person2.NameComparator))
}





























