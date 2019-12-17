package ch02.ex4_4_1_UsingAnInCheck

//使用in 运算符来检查一个值是否在区间中，或者它的逆运算，！ n ，来检查这
//个值是否不在区间中。
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'


//这种检查字符是否是英文字母的技巧看起来很简单。在底层，没有什么特殊处
//理：你依然会检查字符的编码是否位于第一个字母编码和最后一个字母编码之间的
//某个位置。但是这个逻辑被简洁地隐藏到了标准库中的区间类实现中：
//c in 'a'..'z'     变换成a<= c && c <= z
fun main(args: Array<String>) {
    println(isLetter('q'))
    println(isNotDigit('x'))
}
