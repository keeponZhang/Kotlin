package ch07.ex1_2_3_CompoundAssignmentOperators2

//重点
//Kotlin 标准库支持集合的这两种方法。
// 重点1：＋和－运算符总是返回一个新的集合。
//重点2：＋＝和－＝运算符用于可变集合时，始终在一个地方修改它们；
//重点3：:而它们用于只读集合时，会返回一个修改过的副本（这意味着只有当引用只读集合的变量被声明为var 的时候，才能使用＋＝和－＝
fun main(args: Array<String>) {
    val list0 = listOf(100, 200)
    var list01 = listOf(100, 200)
//    Kotlin 标准库为可变集合定义了plusAssign 函数，
    //arrayListOf 其实是可变集合
    val list = arrayListOf(1, 2)
    //上面这个val 只是定义了list不能再指向其他的集合，指向的集合其实是可变的，所以下面这个会报错
//    list = arrayListOf(2)
    var list2 = arrayListOf(5, 6)
    //＋和－运算符总是返回一个新的集合

    //这里会报错，因为＋＝这是listof创建的list0是不可变集合，这是根据重点3，会返回一个新的副本（所以20行会报错，21行可以通过编译）
//    list0 += 3
//    list01 += 3

    list + 2.5
    println("list " + list.hashCode())
    println("list2 " + list.hashCode())

    //理论上plus 和plusAssig 口都可能被调用 a+=b 可能是 a= a.plus(b) ,也可能是a.plusAssign(b)
    //解释1：这里因为list用val修饰，而+ - 返回的是一个新的集合，所以调用的plusAssign，即plus不再使用（kotlin实战书说错了）
    list += 3
    //这个会报错，因为list2是var，可能会调用到plus和plusAssign，会冲突
//    list2 += 4
    //+ 号返回一个包含所有元素的新列表
    val newList = list + listOf(4, 5)
    println("list " + list.hashCode())
    println("list2 " + list.hashCode())
    println(newList.hashCode())
    //这里打印的是【1，2,3】所以符合MutableCollection的plusAssign往原来集合添加数据的解释，所以解释1是对的，这点特别需要注意
    println(list)
    println(newList)
}
