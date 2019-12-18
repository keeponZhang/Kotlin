package ch03.ex5_1_1_SplittingStrings

fun main(args: Array<String>) {

    println("12.345-6.A".split("\\.|-".toRegex()))  //显式地创建一个正则表达式  这里是匹配.或者-
//    这里的模式匹配一个点（我们对它进行转义来表示我们指的是字面量，而不是通配符〉或破折号


    println("12.345-6.A".split("."))  //对于一些简单的情况，就不需要使用正则表达式了
    println("12.345-6.A".split(".", "-")) //指定多个分隔符
}
