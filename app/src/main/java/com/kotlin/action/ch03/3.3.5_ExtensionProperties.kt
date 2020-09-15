package ch03.ex3_5_ExtensionProperties

import ch03.ex3_strings.lastChar    //导入时包名带属性名或者方法名
import ch03.ex3_strings.lastCharShuxing  as lastShuxing  //可以用as来修改导入的类或者函数名称
import ch03.ex3_strings.lastCharShuxing


fun main(args: Array<String>) {
    println("Kotlin".lastChar())
    println("Kotlin".lastCharShuxing)
    println("Kotlin".lastShuxing)
    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)
}


//当你在一个现有的Java项目中集成Kotlin的时候，依然需要面临现有代码目前不能转成
//Kotlin，甚至将来也不会转成Kotlin的局面。当使用这些API 的时候，如果不用重写，
//就能使用到Kotlin为它带来的方便，岂不是更好？这里，可以用扩展函数来实现。
//如上面的String类并没有转换成kotlin
