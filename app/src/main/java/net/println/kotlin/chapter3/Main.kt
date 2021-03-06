package net.println.kotlin.chapter3

/**
 * Created by benny on 3/5/17.
 */
const val FINAL_HELLO_WORLD: String = "HelloWorld"
var helloWorld: String = FINAL_HELLO_WORLD

val FINAL_HELLO_CHINA = "HelloChina"


fun main(args: Array<String>) { // (Array<String>) -> Unit
//    checkArgs(args)
//    val arg1 = args[0].toInt()
//    val arg2 = args[1].toInt()
//    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    //匿名函数调用
    println(int2Long(3))
    println(Sum(1, 3))
    //调用invoke传入1和3和用小括号直接传入是一样的
//    println(Sum.invoke(1, 3))

//    for (i in args){
//        println("原始方法收到的参数 $i")
//    }


//    args.forEach {
//        println(" 收到的参数 $it")
//    }

//    args.forEach { println(it) }
    //用两个冒号来引用函数名作为参数传给forEach,println接收一个参数，
    // forEach的lambda表达式参数也接收一个参数，action的类型也println的类型完全一样
    //如果传入的参数跟lambda表达式的参数类型一样，可以这样简化
    //相当于把传入的it参数直接传给了println
    args.forEach(::println)

    //forEach方法接收的参数是一个lambda表达式
    //args.forEach ({ println(" 收到的参数 $it") })
    //如果最后一个参数是lambda表达式，大括号可以移到小括号外面
    // args.forEach (){ println(" 收到的参数 $it") }
    //（小括号没内容的话，可以直接省略）
    // args.forEach { println(" 收到的参数 $it") }

    // args.forEach ({ it->println(" 传入参数只有一个，可以默认不写，用it 收到的参数 $it") })


    //这是lambda表达式，不是lambda函数，return 相当于return main函数
//    args.forEach {
//        if(it == "q") return
//        println(it)
//    }

    //加个标签，相当于大括号取个标签
//    args.forEach ForEach@{
//        if(it == "q") return@ForEach
//        println(it)
//    }
//
//    println("The End")

    //这两个完全一样
//    println(sum(3,4))
//    println(sum.invoke(3,4))
//
//     println(sum)
    // println(sum)打印结果：Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>
    //其实意思就是Int, Int) -> Int 传两个参数返回一个参数

//    println(int2Long)
    // println(int2Long)打印结果：Function1<java.lang.Integer, java.lang.Long>
    //其实意思就是（Int) -> Long 传一个参数返回一个参数

    //因为这个是具名函数，所以需要加两个冒号来调用
    //如果是类函数，要加类名 Person::age
    println(::printUsage)
    //function printUsage (Kotlin reflection is not available)
    println(::printUsage is ()-> Unit)
}

fun checkArgs(args: Array<String>) {
    if (args.size != 2) {
        printUsage()
        System.exit(-1)
    }
}
//具名函数
fun printUsage() {
    println("请传入两个整型参数，例如 1 2") // (Any?) -> Unit
} // ()->Unit

//参数和返回值用->分隔，当然也不是必须的
// (Int, Int) -> Int 传两个参数返回一个参数的例子
//lambda表达式也是匿名函数，这里就是个匿名函数
val Sum = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${arg1 + arg2}")
    arg1 + arg2
}


// sum 与int2Long其实没什么区别，sum是lambda表达式
//lambda表达式也是匿名函数，这里就是个匿名函数
//(Int)-> Long
//可以用一个变量接收匿名函数
//其实函数也是一个类型，跟String,Int一样，可以赋值，可以传递，只不过它本身是一个代码块，有些特殊用处罢了
val int2Long = fun(x: Int): Long {
    return x.toLong()
}

//lambda 表达式的返回值是最后一行 ；printlnHello没有输入参数 ()-> Unit
val printlnHello = {
    println("Hello")
}




