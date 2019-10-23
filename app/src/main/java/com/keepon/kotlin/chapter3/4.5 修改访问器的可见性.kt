package com.keepon.kotlin.chapter3

/**
 * createBy	 keepon
 */

//访问器的可见性默认与属性的可见性相同，但是如果需要可以通过在get和set关键字前放置可见性修饰符的方式来修改它，
//例如在下面的例子中，我们将setter的可见性修改为private：

class LengthCounter{
    var counter:Int = 0
    private set

    fun addWord(word:String){
        counter+=word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi")
    //这里会报错，因为访问器的可见性为private
//    lengthCounter.counter = 3
    println(lengthCounter.counter)
}










