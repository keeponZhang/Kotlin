package ch03.ex4_2_Varargs

fun main(args: Array<String>) {
//    Kotlin和Java之间的另一个区别是，当需要传递的参数己经包装在数组中时，
//    调用该函数的语法。在Java中，可以按原样传递数组，而Kotlin则要求你显式地解
//    包数组，以便每个数组元素在函数中能作为单独的参数来调用。从技术的角度来讲，
//    这个功能被称为展开运算符，而使用的时候，不过是在对应的参数前面放一个*：
    val list = listOf("新增的args:", *args)
    //输出结果：新增的args
    println(list)
}
