package net.println.kotlin.chapter4

/**
 * Created by benny on 4/4/17.
 */
fun main(args: Array<String>) {
    val latitude = Latitude.ofDouble(3.0)
    val latitude2 = Latitude.ofLatitude(latitude)

    //静态成员考虑用包级函数，变量替代
//    val a = minOf(args[0].toInt(), args[1].toInt())
    println(Latitude.TAG)
    println(Latitude.KEY)
    println(Latitude)
}

class Latitude private constructor(val value: Double) {
    //每个类可以对应一个伴生对象
    //伴生对象的成员全局独一份
    companion object KEY {
        @JvmStatic
        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }

        //相当于静态方法
        fun ofLatitude(latitude: Latitude): Latitude {
            return Latitude(latitude.value)
        }

        @JvmField
        val TAG: String = "Latitude"
    }
}