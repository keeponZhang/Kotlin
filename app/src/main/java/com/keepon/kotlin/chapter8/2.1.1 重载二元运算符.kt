package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */
//假设已经有一个数据类Point，它包含两个成员变量，分别是x,y点的坐标值，
//我们希望通过算术运算符+对两个Point对象相加之后，能够得到一个新的Point对象，
//它的成员变量x,y为原有两个Point对象的x,y之和。

data class Point(var x:Int ,var y:Int){
    operator fun plus(other:Point){
        println("call plus function")
        Point(x+other.x,y+other.y)
    }

}
operator fun Point.plusAssign(other:Point){
    println("call plusAssign function")
    //此时x 用可变 var代替不可变 val
    x +=other.x
    y +=other.y
}





//plus2 会因为找不到这个运算符报错
//operator fun Point.plus2(other:Point):Point{
//    return Point(x+other.x,y+other.y)
//}

fun main(args: Array<String>) {
    val first :Point= Point(1,2)
    val second:Point = Point(3,4)
    println("first+second"+(first+second))
    JavaCallKotlin.javaCallKotlin()

}


//在上面的代码中，我们为Point类定义了一个扩展函数plus，这样当我们调用first + second，
//实际上执行的是first.plus(second)方法来得到一个新的Point对象。这里需要注意的是：
//用于重载运算符的所有函数都需要 用 operator 关键字来标记，用来表示你打算 把这个函数作为相应的约定的实现。

//所有可重载的二元算术运算符如下，自定义类型的运算符，基本上和标准数字类型的运算符有着相同的优先级
//a * b：times
//a / b：div
//a % b：mod
//a + b：plus
//a - b：minus