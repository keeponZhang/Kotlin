package ch04.ex4_1_1_ObjectDeclarations

import java.util.Comparator
import java.io.File

//定义一个类并同时创建一个实例（换句话说就是一个对象）
//与类一样，个对象声明也可以包含属性、方法、初始化语句块等的声明。唯
//一不允许的就是构造方法（包括主构造方法和从构造方法）
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path,
                ignoreCase = true)
    }
}

fun main(args: Array<String>) {
    println(CaseInsensitiveFileComparator.compare(
        File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}
