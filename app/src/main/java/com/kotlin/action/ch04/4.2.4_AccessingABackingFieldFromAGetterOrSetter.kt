package ch04.ex2_4_AccessingABackingFieldFromAGetterOrSetter

class User(val name: String) {
    //这里如果直接返回address，不需要写getter
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            //这里不能用address = value，会导致StackOverflowError
//            address = value
            field = value
        }
}

fun main(args: Array<String>) {
    val user = User("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"
    println(user.address)
}
