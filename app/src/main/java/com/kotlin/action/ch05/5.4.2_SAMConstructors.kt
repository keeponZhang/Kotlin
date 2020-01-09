package ch05.ex4_2_SAMConstructors

//这里不能直接用lambda
//SAM 构造方法只接收一 个参数一一一个被用作函数式接口单抽象方法体的lambda一一并返回实现了这个接口的类的一个实例。
fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}

fun main(args: Array<String>) {
    createAllDoneRunnable().run()
}
