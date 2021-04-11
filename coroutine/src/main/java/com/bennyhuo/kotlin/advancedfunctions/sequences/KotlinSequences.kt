package com.bennyhuo.kotlin.advancedfunctions.sequences

fun main() {
    val list = listOf(1, 2, 3, 4)

//    test1(list)
    test2(list)
//    test3(list)


    //region
//    for (i in 0..10) {
//        println(i)
//    }
//
//    for (e in list) {
//        println(e)
//    }
//
//    var i = 0
//    while (i++ < 10) {
//        println(i)
//    }
//
//    do {
//        println("Hello")
//    } while (false)
//    //endregion
//
//    //region for each
//    list.forEach {
//        if (it == 2) {
//            return@forEach
//        }
//        println(it)
//    }
//
//    list.forEach {
//        if (it == 2) return@forEach
//        println(it)
//    }
//
//    //region
//    val newList = list.flatMap {
//        ArrayList<String>(it)
//    }
//
//    list.filter { it % 2 == 0 }
//    list.asSequence()
//        .filter { it % 2 == 0 }
//
//    list.asSequence()
//        .map { it * 2 + 1 }
//
//    list.asSequence()
//        .flatMap {
//            (0 until it).asSequence()
//        }
//        .joinToString().let(::println)
//
    test4(list)
//
//    list.asSequence()
//        .filter {
//            it % 2 == 0
//        }.map {
//            it * 2 + 1
//        }.flatMap {
//            (0 until it).asSequence()
//        }.forEach(::println)
    //endregion
}

private fun test4(list: List<Int>) {
    //StringBuilder其实就是初始值
    list.fold(StringBuilder()) { acc, i ->
        acc.append(i)
    }
}

private fun test2(list: List<Int>) {
//    Range也是Iterable
    val intRange = 0 until 5
    list
            .flatMap {
                (0 until it)
            }
            .joinToString().let(::println)
}

private fun test3(list: List<Int>) {
    list.asSequence()
            .flatMap {
                (0 until it).asSequence()
            }
            .joinToString().let(::println)
}

private fun test1(list: List<Int>) {
    list.asSequence()
            .filter {
                println("filter: $it")
                it % 2 == 0
            }.map {
                println("map: $it")
                it * 2 + 1
            }.forEach {
                println("forEach: $it")
            }
}
