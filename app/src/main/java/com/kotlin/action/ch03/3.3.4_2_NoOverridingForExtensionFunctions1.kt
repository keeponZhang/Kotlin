package ch03.ex3_4_2_NoOverridingForExtensionFunctions1

open class View {
    open fun click() = println("View clicked")
}

class Button : View() {
    override fun click() = println("Button clicked")
}

fun View.click() = println("I'm a 拓展 view click!")
fun View.click2() = println("I'm a 拓展 view click2!")
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

fun main(args: Array<String>) {
    val view: View = Button()
    view.showOff()

    //I'm a view!
//    扩展函数并不是类的一部分，它是声明在类之外的。尽管可以给基类和子类都
//    分别定义一个同名的扩展函数，当这个函数被调用时，它会用到哪一个呢？这里，
//    它是由该变量的静态类型所决定的，而不是这个变量的运行时类型。
//    如你所见，扩展函数并不存在重写，因为Kotlin会把它们当作静态函数对待。

    view.click()
    view.click2()
//    注意如果一个类的成员函数和扩展函数有相同的签名，成员函数往往会被
//    优先使用。你应该牢记，当在扩展API类的时候：如果添加一个和扩展函
//    数同名的成员函数，那么对应类定义的消费者将会重新编译代码，这将会
//    改变它的意义并开始指向新的成员函数。
}
