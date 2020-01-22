package ch07.ex1_2_1_CompoundAssignmentOperators

data class Point(var x: Int, var y: Int)

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

operator fun Point.plusAssign(other: Point) {
    x += other.x
    y += other.y
}

fun main(args: Array<String>) {
//    var point = Point(1, 2)
//    //解决方法1：注释掉上面任意一个
//    point += Point(3, 4)
//    println(point)

    val point2 = Point(5, 6)
    //解决方法2：point2用val修饰,那就只能调用到plusAssign
    point2 += Point(7, 8)
    println(point2)
}
