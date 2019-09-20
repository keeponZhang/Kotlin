package net.println.kotlin.chapter5.closure

/**
 * Created by benny on 4/15/17.
 */
val string = "HelloWorld"
//闭包
//函数运行的环境
//持有函数运行状态
//函数内部可以定义函数
// 函数内部可以定义类



//()->Unit 表示返回输入为空，返回值为空，下面的匿名函数正好符合
fun makeFun(): ()->Unit{
    var count = 0
    return fun(){
        println(++count)
    }
}
fun fibonacci0(): ()->Long{
    //按照上面的例子
    var first = 0L
    var second = 1L
    return fun():Long{
        var result = second
         second+=first
        first = second -first
        println(" result $result first $first  second $second")
        return result
    }
}



fun fibonacci(): Iterable<Long>{
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator(){
            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
//                println("second $second first $first ")
                return result
            }

            override fun hasNext() = true

        }
    }
}

fun main(args: Array<String>) {
//    var x = makeFun()
//    x() //1
//    x() //2 说明执行后，count没有被释放


//    val fibonacci0 = fibonacci0()
//    println( fibonacci0())
//    println( fibonacci0())
//    println( fibonacci0())
//    println( fibonacci0())

//    for(i in fibonacci()){
//        if(i > 100)break
//        println( i)
//    }

   val add5 = add(5)
    println(add5(2))
    println(add5(1))
}

fun add1(x: Int) = fun(y: Int) = x + y

///等同于add1
fun add(x: Int): (Int)-> Int{

    data class Person(val name: String, val age: Int)

    return fun(y: Int): Int{
        return x + y
    }
}
