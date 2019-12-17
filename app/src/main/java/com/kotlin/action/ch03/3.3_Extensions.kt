package  ch03.ex3_strings

//拓展属性
val String.lastCharShuxing: Char
    get() = get(length - 1)
//拓展方法
fun String.lastChar(): Char = this.get(this.length - 1)

//注意， 扩展函数并不允许你打破它的封装性。和在类内部定义的方法不同的是，扩展函数不能访问私有的或者是受保护的成员。
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }
fun main(args: Array<String>) {
    println("Kotlin".lastChar())
}


//注意， 扩展函数并不允许你打破它的封装性。和在类内部定义的方法不同的是，扩展函数不能访问私有的或者是受保护的成员。