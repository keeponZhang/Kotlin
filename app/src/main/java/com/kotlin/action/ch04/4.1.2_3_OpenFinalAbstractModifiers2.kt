package ch04.ex1_2_3_OpenFinalAbstractModifiers2

abstract class Animated {    //这个类是抽象的，不能实例化
    abstract fun anImate()  //抽象成员始终是open的，所以不需要显式地使用open修饰符；抽象成员不能有实现
    open fun stopAnimating() {   //抽象的非抽象函数并不是默认open的，但是可以标注为open的
    }
}

//顶层属性不能用protected修饰
//protected var testAttr = "keepon";

open class Animator : Animated() {
    override fun anImate() {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override final fun stopAnimating() {  //如果没有使用final表明，重写的成员默认是开放的
        println("重写stopAnimating")
    }
}

class AnimatorSon : Animator() {
//    override fun stopAnimating() {
//        println("重写stopAnimating")
//    }
}

fun main(args: Array<String>) {

}

