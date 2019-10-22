package com.keepon.kotlin.chapter1

/**
 * createBy	 keepon
 */
//得到一个结果的地方成立。同样的规则对try主体和catch子句也有效。if和when都可以使用代码块作为分支体，这种情况下，代码块中的最后一个表达式就是结果，
////这个规则在所有使用代码块并期望

fun evalWithLogging(e:Expr):Int =
        when(e){
            is Num ->{
                println("num:${e.value}")
                //代码块中的最后一个表达式就是结果
                e.value
            }
            is Sum ->{
                val left = evalWithLogging((e.left))
                val right = evalWithLogging((e.right))
                println("sum:$left + $right")
                // //代码块中的最后一个表达式就是结果
                left+right
            }
            else -> throw IllegalArgumentException("Unknown expression") as Throwable
        }

fun main(args: Array<String>) {
    println(evalWithLogging(Sum(Sum(Num(2),Num(3)),Num(4))))
}









