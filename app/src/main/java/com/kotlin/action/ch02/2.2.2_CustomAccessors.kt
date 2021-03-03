package ch02.ex2_2_CustomAccessors

class Rectangle(val height: Int, val width: Int) {
    //自定义访问器：声明属性的getter,属性下一行写get()
    //private//
    val isSquare: Boolean
        get() {
            return height == width
        }

    //private修饰的不会生成get发方法，自定义访问器生成的话也是private类型的
    private val isSquare2: Boolean? = null
//    var isSquare2 : Boolean  var必须初始化赋值
}

fun main(args: Array<String>) {
    val rectangle = Rectangle(41, 43)
    println(rectangle.isSquare)
}
