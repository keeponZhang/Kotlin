package cn.kotliner.coroutine.sequence


/**
 * Created by benny on 5/29/17.
 */
fun main(args: Array<String>) {
    for (i in fibonacci){
        println(i)
        if(i > 100) break
    }
}
val fibonacci = listOf(10,20)
//val fibonacci = buildSequence (){
//    yield(1)
//    var cur = 1
//    var next = 1
//
//    while(true){
//        yield(next)
//        val tmp = cur + next
//        cur = next
//        next = tmp
//    }
//}