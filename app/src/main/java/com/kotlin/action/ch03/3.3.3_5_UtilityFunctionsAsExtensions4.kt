@file : JvmName("StringFunctions")

package ch03.ex3_3_5_UtilityFunctionsAsExtensions4

@JvmOverloads
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

fun main(args: Array<String>) {
    println(listOf("one3", "two3", "eight3").join(" "))
}
