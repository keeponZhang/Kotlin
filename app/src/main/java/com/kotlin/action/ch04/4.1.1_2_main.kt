package ch04.main

class Button : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {  //两个接口有同名方法，必须覆写
//        super<Clickable>.showOff()  //使用尖括号加上父类型名字的"super表明了你想要调用哪一个父 类的方法
//        super<Focusable>.showOff()
    }
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

fun main(args: Array<String>) {
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}
