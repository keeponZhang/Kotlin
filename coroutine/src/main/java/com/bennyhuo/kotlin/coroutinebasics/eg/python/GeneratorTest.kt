package com.bennyhuo.kotlin.coroutinebasics.eg.python

/**
 * createBy	 keepon
 */
fun main() {
    //GeneratorScope<T>类型的lambda表达式，所以yield也是GeneratorScope的方法
//    nums本身还是一个函数，这里支持一个起始参数
    val nums = generator { start: Int ->
        for (i in 0..5) {
            yield(start + i)
        }
    }
//    通过传参获取Generator
    val seq = nums(10)

//    for (j in seq) {
//        println(j)
//    }
    val var3: Iterator<Int> = seq.iterator()
//    调用hasNext的时候就会恢复之前yield挂起的函数
    while (var3.hasNext()) {
        val j: Int = var3.next()
        println(j)
    }

//    val sequence = sequence {
//        yield(1)
//        yield(2)
//        yield(3)
//        yield(4)
//        yieldAll(listOf(1, 2, 3, 4))
//    }
//
//    for (xx in sequence) {
//        println(xx)
//    }
}