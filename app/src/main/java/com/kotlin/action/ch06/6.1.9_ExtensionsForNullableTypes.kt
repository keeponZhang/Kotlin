package ch06.ex1_9_ExtensionsForNullableTypes

fun verifyUserInput(input: String?) {
    //这个拓展函数接收可空的
    //如果你没有使用额外的检查来解引用一个变量比如s.isNullOrBlank()它并不会立即意味着变量是非空的：这个函数有可能是非空类型的扩展函数
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
        return
    }
}

fun main(args: Array<String>) {
    verifyUserInput(" ")
    verifyUserInput(null)
}
