package ch06.ex3_2_ReadonlyAndMutableCollections

fun <T> copyElements(
    source: Collection<T>,
    target: MutableCollection<T>
) {
    for (item in source) {
        target.add(item)
    }
}

fun main(args: Array<String>) {
    val source: Collection<Int> = arrayListOf(3, 5, 7)
    //使用集合的关键点是，只读集合不一定是不变的
    //只读集合并不总是线程安全的
    val target: MutableCollection<Int> = arrayListOf(1)
    var target2: Collection<Int> = arrayListOf(2)
    copyElements(source, target)
//    下面这个会报错不能把只读集合类型的变量作为target 参数传给函数，即便它的值是一个可 变集合：
//    copyElements(source, target2)
    println(target)
}
