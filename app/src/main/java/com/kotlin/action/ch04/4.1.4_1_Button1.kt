package ch04.Button1

import java.io.Serializable

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) { /*...*/ }

//    Kotlin 中没有显式修饰符的嵌套类与Java 中的static 嵌套类是一样的
    class ButtonState : State { /*...*/ }
}
