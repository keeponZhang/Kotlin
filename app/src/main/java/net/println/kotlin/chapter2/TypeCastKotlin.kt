package net.println.kotlin.chapter2

/**
 * Created by benny on 2/26/17.
 */
fun main(args: Array<String>) {
    val parent: Parent = Parent()

//    val child: Child? = parent as Child
    //as 转换失败会异常，as? 转换失败会返回null
    val child: Child? = parent as? Child
    println("child = $child")

    val child2:Parent = Child()
    if(child2 is Child){
        child2.name
    }


    val string: String? = "Hello"
    if(string != null)
        println(string.length)


}