package ch04.ex1_3_可见修饰符

import ch04.main.Focusable

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey !")
    protected fun whisper() = println(" Let ’ s talk !")
}

//类的扩展函数不能访问它的private 和protected 成员。
internal fun TalkativeButton.giveSpeech() {
    //这个也会报错，yell方法是私有的
//    yell()
}
//下面这个会报错，因为类的可见修饰符是internal
//K。由1 禁止从public 函数giveSpeech 去引用低可见的类型TalkativeButton（这个例子中是internal ） 。
//public fun TalkativeButton.giveSpeech2() {
//}
