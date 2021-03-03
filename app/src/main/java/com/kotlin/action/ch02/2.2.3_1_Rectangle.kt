package geometry.shapes

import java.util.Random

//加了priviate，不会生成对应的get方法
class Rectangle(private val height: Int, val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}
