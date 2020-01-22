package ch06.ex3_5_3_Arrays2

fun main(args: Array<String>) {
    val strings = listOf("a", "b", "c")
    //期望vararg参数时使用展开运算符（*）传递数组
    println("%s/%s/%s".format(*strings.toTypedArray()))
//    和其他类型一样，数纽类型的类型参数始终会变成对象类型。因此，如果你声
//    明了一个Array< Int ＞ ，它将会是一个包含装箱整型的数组（它的Java 类型将是java.lang . Integer[J

}
