package ch04.ex1_2_3_OpenFinalAbstractModifiers2

abstract class Animated {
    abstract fun anImate()  //抽象成员始终是open 的， 所以不需要显式地使用open 修饰符 ； 抽象成员不能有实现
    open fun stopAnimating() {   //抽象叫象函数并不是默认open 的，但是可以标注为open 的
    }
}

open class Animator : Animated() {
    override fun anImate() {
        TODO(
            "not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override final fun stopAnimating() {  //如果没有使用final 表明，亟写的成员默认是开放的
        println("重写stopAnimating")
    }
}

class AnimatorSon : Animator() {
//    override fun stopAnimating() {
//        println("重写stopAnimating")
//    }
}