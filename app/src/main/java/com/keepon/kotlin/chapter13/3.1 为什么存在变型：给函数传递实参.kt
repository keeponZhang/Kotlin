package com.keepon.kotlin.chapter13

/**
 * createBy	 keepon
 */
//假设你有一个接受List<Any>作为实参的函数，那么把List<String>类型的变量传递给这个函数是否安全呢？我们来看下面两个例子：

//第一个例子：

fun printContents(list: List<Any>) {
    println(list.joinToString())
}

fun main(args: Array<String>) {
//    printContents(listOf("abc", "bac"))


//    这里声明了一个类型为MutableList<String>的变量strings，然后尝试把它传递给一个接收MutableList<Any>的函数，
//    编译器将不会通过调用。
//    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings)
//    因此，当我们将一个字符串列表传递给期望Any对象的列表时，如果 函数添加或者替换了 列表中的元素（通过MutableList来推断）就是不安全的，因为这样会产生类型不一致的可能，否则它就是安全的。
}

//这上面的函数可以正常地工作，函数把每个元素都当作Any对待，而且因为每个字符都是Any，因此这是完全安全的，运行结果为：


//第二个例子，与之前不同，它会修改列表：
fun addAnswer(list : MutableList<Any>) {
    list.add(42)
}




















