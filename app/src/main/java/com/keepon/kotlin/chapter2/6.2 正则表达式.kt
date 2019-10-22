package com.keepon.kotlin.chapter2

/**
 * createBy	 keepon
 */
fun  parsePath(path:String){
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val  fileName = fullName.substringBeforeLast(".")
    val extention = fullName.substringAfterLast(".")
    println("Dir:$directory,fullName:$fullName,fileName:$fileName,ext:$extention")
}
//下面是使用正则表达式的做法：

//这个正则表达式将一个路径分为三个由斜线和点分隔的组：
//.模式从字符串的一开始就进行匹配，所以第一组(.+)包含最后一个斜线之前的子串，这和子串包含所有前面的斜线，因为它们匹配”任何字符“的模式。
//第二组包含最后一个点之前的子串
//第三组包含剩余部分
fun  parsePath2(path:String){
   val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult!=null){
        val(directory,fileName,extention)= matchResult.destructured
        println("Dir2:$directory,fileName:$fileName,ext:$extention")
    }
}
fun  parsePath3(path:String){
    val regex = """(.+)/(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if(matchResult!=null){
        val(directory,fileName)= matchResult.destructured
        println("Dir3:$directory,fileName:$fileName")
    }
}

fun main(args: Array<String>) {
//    parsePath("/User/you/kotlinbook/chapter.doc")
    parsePath2("/User/you/kotlinbook/chapter.doc")
//    parsePath3("/User/you/kotlinbook/chapter.doc")
}























