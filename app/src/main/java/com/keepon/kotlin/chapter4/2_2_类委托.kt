package com.keepon.kotlin.chapter4

/**
 * createBy	 keepon
 */
//这里用了委托，不用实现那么多的方法
//innerSet:MutableCollection<T> =HashSet<T>() 这里相当于给innerSet默认值了
class  CountingSet<T>(val innerSet:MutableCollection<T> =HashSet<T>()):MutableCollection<T> by innerSet{
    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded+=elements.size
        return innerSet.addAll(elements)
    }

    var objectsAdded  = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return  innerSet.add(element)
    }
}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,2,4))
    cset.remove(1)
    println("${cset.objectsAdded} objects were added,${cset.size} remain")
}