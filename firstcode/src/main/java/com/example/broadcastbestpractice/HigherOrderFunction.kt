package com.example.broadcastbestpractice

inline fun printString(str: String, block: (String) -> Unit) {
    println("!!!!!!printString begin!!!!!!!!!!")
    block(str)
    println("!!!!!!!printString end!!!!!!!!")
}

fun printString2(str: String, block: (String) -> Unit) {
    println("printString2 begin")
    block(str)
    println("printString2 end")
}

inline fun runRunnable(crossinline block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

fun runRunnable2(block: () -> Unit) {
    val runnable = Runnable {
        block()
    }
    runnable.run()
}

inline fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

fun num1AndNum3(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    val result = operation(num1, num2)
    return result
}

val stringBuilder = StringBuilder()
fun main(args: Array<String>) {
    val num1 = 100
    val num2 = 80
    //使用lambda表达式的写非
    val result1 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 + n2
    }
//    int result$iv = num1 - num2;
    val result2 = num1AndNum2(num1, num2) { n1, n2 ->
        n1 - n2
    }
    //int result3 = num1AndNum3(num1, num2, (Function2)null.INSTANCE);
    val result3 = num1AndNum3(num1, num2) { n1, n2 ->
        n1 - n2
    }
    println("result1 is $result1")
    println("result2 is $result2")
    println("result3 is $result3")


    val list = listOf("Apple", "Banana", "Orange", "Pear", "Grape")

    //编译器会把调用者传进去，自己传反而不行
    val result = stringBuilder.build {
        append("Start eating fruits.\n")
        for (fruit in list) {
            append(fruit).append("\n")
        }
        append("Ate all fruits.")
    }
    //这里会报错
//    val resul2 = stringBuilder.build2 {
//        append("Start eating fruits.\n")
//        for (fruit in list) {
//            append(fruit).append("\n")
//        }
//        append("Ate all fruits.")
//    }
    val resul3 = stringBuilder.build3 {
        println("this is result3")
    }
    println(result.toString())


    println("main start")
    val str = ""
    //内联函数所引用的Lamda表达式是可以用return关键字进行函数返回的,是针对main函数哦，这点要注意
    //还要注意一点，block真正的参数等被调用才会赋值，这里因为block(str),所以s就是str
    printString(str) { s ->
        println("&&&&&lambda start&&&&&")
        //return顺序不要求
        //main函数返回
        if (s.isEmpty()) return
        //局部返回
        if (s.length == 1) return@printString

        println(s)
        println("&&&&&&&&lambda end&&&&&&")
    }
    println("main end")

    //printString2非内联函数，所以return那里会编译报错
    println("main2 start------")
    val keepon = ""
    printString2(keepon) { s ->
        println("lambda2 start")
        if (s.isEmpty()) ""
        println(s)
        println("lambda2 end")
    }
    println("main2 end-------")
//使用了crossinline，block里面再用return就会编译不过
//    runRunnable { if (str1.isEmpty()) return }
    runRunnable { if (keepon.isEmpty()) return@runRunnable }
}

fun plus(num1: Int, num2: Int): Int {
    return num1 + num2
}

fun minus(num1: Int, num2: Int): Int {
    return num1 - num2
}

//表示函数类型是定义在StringBuilder类的，所以block自然可以调用StringBuilder的方法, StringBuilder.()这种限定类的block，会用
// Fuc1代替，默认把调用者作为参数传入
fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}

fun StringBuilder.build2(block: () -> Unit): StringBuilder {
    block()
    return this
}

fun StringBuilder.build3(block: (String) -> Unit): StringBuilder {
    block("keepon")
    return this
}
/**一个会把调用对象传进去，一个不会
 *  @NotNull
public static final StringBuilder build(@NotNull StringBuilder $receiver, @NotNull Function1 block) {
Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
Intrinsics.checkParameterIsNotNull(block, "block");
block.invoke($receiver);
return $receiver;
}

@NotNull
public static final StringBuilder build2(@NotNull StringBuilder $receiver, @NotNull Function0 block) {
Intrinsics.checkParameterIsNotNull($receiver, "$receiver");
Intrinsics.checkParameterIsNotNull(block, "block");
block.invoke();
return $receiver;
}
 */
