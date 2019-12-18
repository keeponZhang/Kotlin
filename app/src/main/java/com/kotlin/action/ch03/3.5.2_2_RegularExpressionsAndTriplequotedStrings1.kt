package ch03.ex5_2_2_RegularExpressionsAndTriplequotedStrings1

fun parsePath(path: String) {
//   \ 将下一个字符标记符、或一个向后引用、或一个八进制转义符。例如，“\\n”匹配\n。“\n”匹配换行符。序列“\\”匹配“\”而“\(”则匹配“(”。
    //. 是一个或者多个任意字符
    //(.+)/最后一个斜线，(.+)\.最后一个点  (.+)剩余的
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        for (group in matchResult.groupValues) {
            println("group0  $group")
        }
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}
fun parsePath2(path: String) {
    val regex = """(.+)/(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename) = matchResult.destructured
        val groupValues = matchResult.groupValues
        for (group in groupValues) {
            println("group  $group")
        }
        println("Dir: $directory")
    }
}

fun main(args: Array<String>) {
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePath2("/Users/yole/kotlin-book/chapter2.adoc")
}
