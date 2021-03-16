package ch06.ex3_3_2_KotlinPingtai

import com.keepon.kotlin.chapter7.DataParser
import com.kotlin.action.ch06.CollectionUtils
import com.kotlin.action.ch06.Person
import com.kotlin.action.ch06.java.FileContentProcessor
import java.io.File
//注意，同样的Java 类型一－ List<String ＞一一如何表示成了两种不同
//的Kotlin 类型： 一种是List<String>? （包含字符串的可空列表），另一种是
//MutableList< String?> （包含可空字符串的可变列表）。为了做出正确的选择，
//你必须知道Java 接口或类必须遵守的确切契约。基于你的实现要做的事情这通常很
//容易理解。
class Fileindexer : FileContentProcessor {
    override fun processContents(
        path: File, binaryContents: ByteArray, textContents: List<String>
    ) {
        TODO("Not yet implemented")
    }
}

class Fileindexer2 : FileContentProcessor {
    override fun processContents(
        path: File?, binaryContents: ByteArray?, textContents: List<String>?
    ) {
        TODO("Not yet implemented")
    }
}

class PersonParser : DataParser<Person> {
    override fun parseData(
        Input: String,
        output: MutableList<Person>,
        errors: MutableList<String?>
    ) {
    }
}

fun main(args: Array<String>) {
}
