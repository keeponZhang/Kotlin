package ch03.ex3_4_1_NoOverridingForExtensionFunctions

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun main(args: Array<String>) {
    val view: View = Button()
    view.click()

// Button clicked   具体调用哪个方法，由实际的 view 的值来决定
}

