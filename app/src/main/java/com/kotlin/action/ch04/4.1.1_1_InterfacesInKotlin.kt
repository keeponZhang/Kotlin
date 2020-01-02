package ch04.ex1_1_1_InterfacesInKotlin

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
