package cn.kotliner.kotlin.io

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/**
 * Created by benny on 5/28/17.
 */
fun main(args: Array<String>) {
    val file = File("build.gradle")
    //用use，不用手动关闭
    BufferedReader(FileReader(file)).use {
        var line: String
        while(true){
            line = it.readLine()?:break
            println(line)
        }
    }
}