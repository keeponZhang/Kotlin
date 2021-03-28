package net.println.kotlin.chapter2

import net.println.kotlin.chapter2.市委书记.北京.市委书记

/**
 * Created by benny on 2/26/17.
 */
//为了避免不必要的装箱和拆箱，基本类型的数组是定制的
//int[] IntArray
//short[] ShortArray
//long[] LongArray
//float[] FloatArray
//double[] DoubleArray
//char[] CharArray
val arrayOfInt: IntArray = intArrayOf(1,3,5,7)
val arrayOfChar: CharArray = charArrayOf('H', 'e','l','l','o','W','o','r','l','d')
val arrayOfChar2: Array<Char> = arrayOf('a', 'b','c')
val arrayOfString: Array<String> = arrayOf("我", "是", "码农")
val arrayOf书记: Array<市委书记> = arrayOf(市委书记("章"), 市委书记("赵"), 市委书记("黄"))

fun main(args: Array<String>) {
    println("arrayOfInt.size ${arrayOfInt.size}")
    for(int in arrayOfInt){
        println(int)
    }

    println("arrayOf书记[1] ${arrayOf书记[1]}")
    arrayOf书记[1] = 市委书记("方")
    println("arrayOf书记[1] ${arrayOf书记[1]}")


    println("arrayOfChar.joinToString()="+arrayOfChar.joinToString())
    println("arrayOfInt.slice(1..3)="+arrayOfInt.slice(1..3))
}