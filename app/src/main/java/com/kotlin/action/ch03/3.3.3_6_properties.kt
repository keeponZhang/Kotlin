package ch03.ex3_3_3_6_properties

var opCount = 0;
fun performOperation() {
    opCount++
}

const val MY_STATIC = "我是静态属性"
fun reportOperationCount() {
    println("Operation performed $opCount  times")
}

fun main(args: Array<String>) {
    performOperation()
    reportOperationCount()
}