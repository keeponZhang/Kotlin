package cn.kotliner.kotlin.sam

import java.util.*

/**
 * Created by benny on 5/30/17.
 */
//这里表示既支持java的接口，也支持kotlin的接口
typealias Runnable=()->Unit

class SAMInKotlin{
    fun addTask(runnable: Runnable){

    }
    fun addObserver(observer: Observer){

    }
}