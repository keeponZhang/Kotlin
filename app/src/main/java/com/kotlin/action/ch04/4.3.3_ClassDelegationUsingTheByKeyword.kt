package ch04.ex3_3_ClassDelegationUsingTheByKeyword

import java.util.HashSet

//这里有个默认参数，所以构造的时候可以不传
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {    //Kotlin将委托作为一个语言级别的功能做了头等支持。无论什么时候实现一个接口，你都可以使用by
// 关键字将接口的实现委托到另一个对象


    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1, 1, 2))
    println("${cset.objectsAdded} objects were added, ${cset.size} remain")
}
