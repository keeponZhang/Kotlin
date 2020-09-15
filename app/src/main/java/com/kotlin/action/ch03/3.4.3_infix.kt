package ch03.ex4_3_infix

fun main(args: Array<String>) {
    //public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    1.to("one ")
    val map = mapOf("key" to "value", "2" to "whatever")

}

//中缀调用可以与只有一个参数的函数一起使用，无论是普通的函数还是扩展函
//数。要允许使用中缀符号调用函数，需要使用infix修饰符来标记它。
//下面是一个简单的to函数的声明：
//public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
//to 函数会返回一个Pair 类型的对象，Pair是Kotlin标准库中的类，不出所料，
//它会用来表示一对元素。Pair 和to的声明都用到了泛型，简单起见，这里我们省
//略了泛型。
//注意，可以直接用Pair的内容来初始化两个变量：这个功能称为解构声明
//val(number,name) = 1 to "one"

//解构声明特征不止用于pair。例如，还可以使用map的key和value内容来
//初始化两个变量。
//这也适用于循环，正如你在使用withindex函数的joinToString实现中
//看到的：
//for((index, element) in collection.withindex())
//println("$index: $element")
//
//
//to函数是一个扩展函数，可以创建一对任何元素，这意味着它是泛型接收者的
//扩展：可以使用1 to " one ” 、＂ one " to l, list to list .size （）等写法。

//我们来看看mapOf 函数的声明：
//fun <K, V> mapOf(vararg values: Pair<K, V>): Map<K , V>
//像listOf一样，mapOf接收可变数量的参数，但是这次它们应该是键值对。
//尽管在Kotlin中创建新的map 可能看起来像特殊的解构，而它不过是一个具有
//简明语法的常规函数。接下来，我们来讨论扩展函数如何简化字符串和正则表达式
//的操作。