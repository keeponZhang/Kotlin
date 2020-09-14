package ch02.ex2_2_CustomAccessors

class Rectangle(val height: Int, val width: Int) {
    //自定义访问器：声明属性的getter,属性下一行写get()
    val isSquare: Boolean
        get() {
            return height == width
        }
//    var isSquare2 : Boolean  var必须初始化赋值
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
