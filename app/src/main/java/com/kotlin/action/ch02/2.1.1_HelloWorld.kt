package ch02.ex1_1_HelloWorld

fun main(args: Array<String>) {
    println("Hello, world!")
    println("<top>.main")
    Thread(object : Runnable {
        override fun run() {
            TODO("Not yet implemented")
        }
    }).start()
    Thread({ println("test") }).start()
}
