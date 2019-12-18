package ch04.ex1_3_可见修饰符

import ch04.main.Focusable

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey !")
    protected fun whisper() = println(" Let ’ s talk !")
}

internal fun TalkativeButton.giveSpeech() {
}
//下面这个会报错，因为类的可见修饰符是internal
//public fun TalkativeButton.giveSpeech2() {
//}
