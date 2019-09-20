package net.println.kotlin.chapter5.builtins

import net.println.kotlin.chapter5.tailrecursive.factorial

/**
 * Created by benny on 4/15/17.
 */


fun main(args: Array<String>) {


//    val list = listOf(1,2,4,6)
//    var newlist = ArrayList<Int>()
//    list.forEach{
//        val  newElement = it*2
//        newlist.add(newElement)
//    }


    //返回值加到list集合
//    var newlist = list.map {
//        println("map 功能测试")
//        it*2
//    }
    //通过类名::方法名调用的，有默认的参数，就是调用它的那个实例，也就是it
    //Int::toDouble是放在括号里，不是分号里
//    var newlist2 = list.map (Int::toDouble)

//    newlist.forEach {
//        println("new list element $it")
//    }
//    newlist2.forEach (::println)
    var range: IntRange = 1..3;
    println("range $range")


    var list = listOf(1..10, 2..5, 100..110)
    list.forEach(::println)


    var destination:ArrayList<Int> = ArrayList()
    for (element in list) {
        destination.addAll(element)
    }
    destination.forEach {
        println("添加到集合再遍历 $it")
    }


    //IntRange 实现了Iterable接口
    var flatList = list.flatMap {
        intRange -> intRange.map { item -> "No $item" }
    }
    flatList.forEach(::println)


//    var sum = list.flatMap {
//        it
//    }.reduce { acc, i ->
//        println("acc = $acc    i = $i")
//        acc+i }
//    println("sum $sum")
    val factorial = factorial(5)
    println("5的阶乘 == $factorial")

    (0..5).map {item->factorial(item) }.forEach{
        println("it $it")
    }

    (0..5).map {item->factorial(item) }.reduce { acc, i ->
        println("reduce acc = $acc    i = $i")
        acc+i }

    val filter = (0..5).map { item -> factorial(item) }.filter { it % 2 == 0 }
    println("过滤  $filter")
    (0..5).map { item -> factorial(item) }.filterIndexed{index,it ->
        println("index $index it $it")
        if(index %2 == 1){
             true
        }else{
             false
        }
    }
    val takeWhile = (0..5).map { item -> factorial(item) }.takeWhile {
        println("takeWhile it $it")
        it % 2 == 1 }
    println("takeWhile ${takeWhile.size}")


    println("准备用fold啦..................")
    (0..5).map {item->factorial(item) }.fold(5){acc, i ->
        println("folder 5 acc = $acc    i = $i")
        acc+i
    }

    println("准备用fold2 StringBuilder append啦..................")
    println((0..5).fold(StringBuilder()){ acc, i ->
        println("StringBuilder folder 5 acc = $acc    i = $i")
        acc.append(i).append(",")
    })
    println((0..5).joinToString())
}
fun factorial(n:Int):Int{
    if(n == 0) return 1
    return (1..n).reduce { acc, i -> acc*i }
}
