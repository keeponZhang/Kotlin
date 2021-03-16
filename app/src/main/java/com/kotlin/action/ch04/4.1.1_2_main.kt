package ch04.main

//这里将构造参数与属性关联（接口的属性其实也是用方法实现的，必须重写，可以在构造函数或者直接覆写属性）
class Button(override var test: String) : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {  //两个接口有同名方法，必须覆写
//        super<Clickable>.showOff()  //使用尖括号加上父类型名字的"super表明了你想要调用哪一个父 类的方法
//        super<Focusable>.showOff()
    }
}

private class Button2() : Clickable, Focusable {
    override var test: String = "keepon"
    override fun click() = println("I was clicked")

    override fun showOff() {  //两个接口有同名方法，必须覆写
//        super<Clickable>.showOff()  //使用尖括号加上父类型名字的"super表明了你想要调用哪一个父 类的方法
//        super<Focusable>.showOff()
    }
}

interface Clickable {
    //kotlin接口可以有属性，但是实现该接口的类必须重写该属性；可以自定义getter
    //经测试，用var修饰也可以（var定义的话会有2个方法）
    var test: String

    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")

    fun showOff() = println("I'm focusable!")
}

fun main(args: Array<String>) {
    val button = Button("keepon2")
    button.showOff()
    button.setFocus(true)
    button.click()
}
