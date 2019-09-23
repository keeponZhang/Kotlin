package net.println.kotlin.chapter6

/**
 * Created by benny on 5/29/17.
 */
//说明调用这个方法，传入lambda表达式，第一个参数是Tag的实例this
//实现的话一般是实例话，然后调用apply方法，再把lambda表达式作为apply的参数传入
fun html(block: Tag.()->Unit): Tag{
    //调用apply  不会调用String.invoke(block: Tag.()->Unit)
    //apply可以把调用者作为参数传到lambda表达式
//    return Tag("html").apply(block)
    return Tag("html").apply{block(this)}
}

fun Tag.head(block: Head.()->Unit){

    this + Head().apply(block)
}

fun Tag.body(block: Body.()->Unit){
    println("body ---")
    val apply = Body().apply(block)
    this+apply
    println("after body ---- $apply")
}

class StringNode (val content: String): Node{
    override fun render():String {
        println("String Node 这里啊")
        return  content
    }
}

class Head: Tag("head")

class Body: Tag("body"){
    var id by MapDelegate(proerties)

    var `class` by MapDelegate(proerties)
}