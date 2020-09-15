package ch04.ex1_1_1_InterfacesInKotlin


//在Java中实现包含方法体的接口
//Kotlin1.0是以Java6为目标设计的，其并不支持接口中的默认方法。因此
//它会把每个带默认方法的接口编译成一个普通接口和一个将方法体作为静态函
//数的类的结合体。接口中只包含声明，类中包含了以静态方法存在的所有实现。
//因此，如果需要在Java 类中实现这样一个接口，必须为所有的方法，包括在
//Kotlin 中有方法体的方法定义你自己的实现。
interface Clickable {
    fun click()
    fun clickDefault() {
        println("Clickable 接口的默认实现")
    }
}

class Button : Clickable {
    override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
    Button().click()
    Button().clickDefault()
}
