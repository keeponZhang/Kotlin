package ch04.ex1_5_2_SealedClasses1

//为父类添加一个sealed 修饰符，对可能创建的子类做出严格的限制。所有的直接子类必须嵌套在父类中
//sealed 修饰符隐含的这个类是一个open类
sealed class Expr() {
    //在这种情况下， Expr 类有一个只能在类内部调用的private 构造方法
    class Num(val value: Int) : Expr()

    class Sum(val left: Expr, val right: Expr) : Expr()
}


//在Kotlin1.0中，sealed功能是相当严格的。例如，所有的子类
//必须是嵌套的，并且子类不能创建为dat类（data类会在本章后面部
//分提到)。Kotlin1.l解除了这些限制并允许在同一文件的任何位直定义sealed类的子类。
class Sum2(val left: Expr, val right: Expr) : Expr()

//不能声明一个sealed接口。为什么？如果你能这样做，Kotlin编译器不能保证任何人都不能在Java代码中实现这个接口。
//sealed interface Expr2 {
//}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        is Sum2 -> eval(e.right) + eval(e.left)
    }

fun main(args: Array<String>) {
    println(eval(Expr.Sum(Expr.Sum(Expr.Num(1), Expr.Num(2)), Expr.Num(4))))
}
