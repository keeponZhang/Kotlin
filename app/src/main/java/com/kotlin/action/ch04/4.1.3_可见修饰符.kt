package ch04.ex1_3_可见修饰符

import ch04.main.Focusable

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey !")
    protected fun whisper() = println(" Let ’ s talk !")
}

private class TalkativeButton3 : Focusable {
    private fun yell() = println("Hey !")
    protected fun whisper() = println(" Let ’ s talk !")
}

//类的扩展函数不能访问它的private和protected 成员。
internal fun TalkativeButton.giveSpeech() {
    //这个也会报错，yell方法是私有的
//    yell()
    //这个也会报错，yell方法是protected
//    whisper()
}
//下面这个会报错，因为类的可见修饰符是internal。
//由1禁止从public函数giveSpeech去引用低可见的类型TalkativeButton（这个例子中是internal ） 。
//public fun TalkativeButton.giveSpeech2() {
//}


//Kotlin的可见性修饰符和Java
//Kotlin中的public、protected和private修饰符在编译成Java字节
//码时会被保留。你从Java代码使用这些Kotlin声明时就如同他们在Java中声明
//了同样的可见性。唯一的例外是private类：在这种情况下它会被编译成包私
//有声明（在Java中你不能把类声明为private)。
//但是，你可能会问，internal修饰符将会发生什么？Java中并没有直接
//与之类似的东西。包私有可见性是一个完全不同的东西：一个模块通常会由多
//个包组成，并且不同模决可能会包含来自同一个包的声明。因此internal修
//饰符在字节码中会变成public。
//这些Kotlin声明和它们Java翻版（或者说它们的字节码呈现）的对应关
//系解释了为什么有时你能从Java代码中访问一些你不能从Kotlin中访问的东西。
//例如，可以从另一个模块的Java代码中访问internal 类或顶层声明，抑或从
//同一个包的Java代码中访问一个protected 的成员（与你在Java中做的相似）。
//但是注意类的internal成员的名字会被破坏。从技术上讲， internal
//成员也是可以在Java中使用的，但是它们在Java代码中看起来很难看。当你从
//另一个模块继承类时，可以帮助避免在重写时出现出乎意料的冲突，并且避免
//意外f史用internal类。