package geometry.shapes

import java.util.Random

//加了priviate，不会生成对应的get方法
class Rectangle(private val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

//主构造函数不能这样
//class Rectangle2(private val height: Int, val width: Int get() {
//    return width
//}) {
//    val isSquare: Boolean
//    get() = height == width
//}

class Rectangle3(private val height: Int, var width: Int) {
    //有主构造函数，一定要调用主构造函数，且副构造函数不能用val修饰
    constructor(height: Int) : this(height, 2) {
    }

    val isSquare: Boolean
        get() = height == width
}

//自定义构造器只能用在属性
//class Rectangle4(private val height: Int, var width: Int) {
//    init {
//        val height: Int
//        get() = 5
//    }
//}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
