package ch04.ex1_2_1_OpenFinalAbstractModifiers

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {

    fun disable() {}

    open fun animate() {}

    //这里只有override，没有final，代表也是可以重写的
    override fun click() {}
}

class ChildRichButton : RichButton() {
    override fun click() {}
}
