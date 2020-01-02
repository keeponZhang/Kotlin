package ch04.ex3_1_2_2_ObjectEqualityEquals1

class Client(val name: String, val postalCode: Int) {

    //    Any ” 是java.lang.ObjectKotlin 中所有类的父类。可空类型“Any ？ ”意 昧着“other ” 是可以为空的
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name.equals(other.name) &&
            postalCode == other.postalCode
    }

    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
}

fun main(args: Array<String>) {
    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    println(client1 == client2)
    val processed = hashSetOf(Client("Alice", 342562))
    println(processed.contains(Client("Alice", 342562)))
}
