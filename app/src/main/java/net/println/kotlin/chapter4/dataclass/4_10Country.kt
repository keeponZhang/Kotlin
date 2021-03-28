package net.println.kotlin.chapter4.dataclass

import net.println.kotlin.chapter4.annotations.PoKo

/**
 * Created by benny on 4/4/17.
 */
@PoKo
//加了data会默认给我们生成toString方法，编译成final class ，没有无参构造函数
data class Country(val id: Int, val name: String)

class ComponentX {
    operator fun component1(): String {
        return "您好，我是"
    }

    operator fun component2(): Int {
        return 1
    }

    operator fun component3(): Int {
        return 1
    }

    operator fun component4(): Int {
        return 0
    }
}

fun main(args: Array<String>) {
    //编译不行，运行时才可以
//    val china1 = Country()
    val china = Country(0, "中国")
    println(china)
    //component1就是第一个参数，component2就是第二个参数
    println(china.component1())
    println(china.component2())

    //id会用component1来赋值
    val (id, name) = china
    println(id)
    println(name)
//

    //这种写法跟上面的是一样的，因为 args.withIndex()返回的是data class IndexedValue
//    for ((index, value) in args.withIndex()) {
//        println(index)
//    }

    val componentX = ComponentX()
    val (a, b, c, d) = componentX
    println("$a $b$c$d")
}