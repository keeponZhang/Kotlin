package ch05.ex3_1_2_ExecutingSequenceOperations1

fun main(args: Array<String>) {
    //asSequence会把调用者的iterator保存下来
    //为什么需要把序列转换回集合？答案是： 有的时候是这样。如果你只需要迭代序列中的元素，可以
    //直接使用序列。如果你要用其他的AP I 方法，比如用下标访问元素，那么你需要把序列转换成列表。
    println(listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }
        .toList())

}
