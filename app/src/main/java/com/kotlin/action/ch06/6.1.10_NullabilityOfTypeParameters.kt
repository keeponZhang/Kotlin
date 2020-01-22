package ch06.ex1_10_NullabilityOfTypeParameters

//类型参数T 推导出的类型是可空类型Any ？
fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}
fun <T : Any> printHashCode2(t: T) {
    println(t?.hashCode())
}

fun main(args: Array<String>) {
    printHashCode(null)
    //下面这个通不过编译
//    printHashCode2(null)
}
