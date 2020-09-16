package ch04.ex1_2_1_OpenFinalAbstractModifiers

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {

    open fun disable() {}

    open fun animate() {}

    //这里只有override，没有final，代表也是可以重写的
    override fun click() {}
}

open class ChildRichButton : RichButton() {
    override fun click() {}
    override fun animate() {}

    //    如果你重写了一个基类或者接口的成员，重写了的成员同样默认是open的。
    final override fun disable() {}
    val test2 = 22
}

class ChildRichButton2 : ChildRichButton() {
    override fun click() {}
    override fun animate() {}
    val test22 = 2
//    override fun disable() {}
}

fun main(args: Array<String>) {
    val richButton = ChildRichButton()
    if (richButton is ChildRichButton) {
        richButton.test2
//        richButton = ChildRichButton2
    }
    if (richButton is ChildRichButton2) {
        richButton.test22
    }
}

//Open类和智能转换
//类默认为final带来了一个重要的好处就是这使得在大量场景中的智能转
//换成为可能。正如我们在2.3.5节中提到的，智能转换只能在进行类型检查后没
//有改变过的变量上起作用。对于一个类来说，这意味着智能转换只能在val类
//型并且没有自定义访问器的类属性上使用。这个前提意味着属性必须是final的，
//否则如果一个子类可以重写属性并定义一个自定义的访问器将会打破智能转换
//的关键前提。因为属性默认是final的，可以在大多数属性上不加思考地使用
//智能转换，这提高了你的代码表现力。

//实际是类型转换后，不能再重新赋值其他类型