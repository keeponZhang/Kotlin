package ch04.ex1_2_2_OpenFinalAbstractModifiers1

interface Clickable {
    //加上final会报错，因为接口方法都应该是可以重写的
//    final fun click()
     fun click()
    fun showOff() = println("I'm clickable!")
}

open class RichButton : Clickable {
    final override fun click() {}
}
