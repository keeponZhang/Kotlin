package ch02.colors


//这是极少数Kotiin声明比Java 使用了更多关键字的例子： Kotlin用了enum
//class两个关键字，而Java只有enum一个关键字。
//Kotlin中，enum 是一个所谓的软关键字：只有当它出现在class前面时才有特殊的意义，在其他地方可以把
//它当作普通的名称使用。
enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}
