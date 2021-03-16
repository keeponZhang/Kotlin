package ch06.ex1_6_NotnullAssertions

fun ignoreNulls(s: String?) {
//    如果对null 值做非空断言，则会抛出异常。
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun main(args: Array<String>) {
    ignoreNulls(null)
}
