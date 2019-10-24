package com.keepon.kotlin.chapter7

import java.io.BufferedReader
import java.io.StringReader

/**
 * createBy	 keepon
 */
//在 Kotlin 知识梳理(6) - Kotlin 的可空性 中，我们讨论了可空类型的概念，但仅仅简略地谈到类型参数的可空性，
//其实集合也可以持有null元素，和变量可以持有null一样，类型在被当作类型参数时也可以用同样的方式来标记。
//
//下面我们创建一个包含可空值的集合，之后遍历该集合，打印出有效的数字之和以及为null的集合元素个数：
//

fun readNumbers(reader: BufferedReader):List<Int?>{
    val result = ArrayList<Int?>()
    for(line in reader.lineSequence()){
        try {
            val number = line.toInt()
            result.add(number)
        }catch (e :Exception){
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers:List<Int?>){
    var sumOfValidNumbers = 0
    var invalidNumbers = 0
    for (i in numbers) {
        if(i!=null){
            sumOfValidNumbers+= i
        }else{
            //记录为null的个数
            invalidNumbers++
        }
    }
    println("sum of valid numbers: $sumOfValidNumbers")
    println("sum of invalidNumbers numbers: $invalidNumbers")
}

fun main(args: Array<String>) {
    val  reader = BufferedReader(StringReader("1\nabc\n33"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)
}







