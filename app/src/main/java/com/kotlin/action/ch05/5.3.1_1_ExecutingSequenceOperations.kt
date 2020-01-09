package ch05.ex3_1_1_ExecutingSequenceOperations

fun main(args: Array<String>) {
    //这里会创建3个Sequence,此时不会有结果输出
    println(listOf(1, 2, 3, 4).asSequence()
        .map { print("map($it) "); it * it }
        .filter { print("filter($it) "); it % 2 == 0 }.iterator())

}
