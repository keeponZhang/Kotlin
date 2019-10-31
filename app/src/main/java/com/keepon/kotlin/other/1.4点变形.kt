package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
//事实上，真正的动物园，既需要收养，也需要放生；但是如果我们需要一个既包含adoption，
//又包含release方法的Zoom，那只能把它声明成不型变的了。但这样的话会给我们的编程带来诸多不便，
//我们也就不可能写出更具复用性的代码。因此，点变形出现了，看下面的例子：

abstract open class Zoom8<T>(t: T) {
    //收养
    abstract fun adoption(t: T)
    //放生
    abstract  fun release(): T
}

class Zoom9( animal: Animal) : Zoom8<Animal>(animal){
    override fun adoption(t: Animal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun release(): Animal {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun function8(zoom: Zoom8<out Animal>) {
    val animal: Animal = zoom.release()
}

fun function9(zoom: Zoom8<in Dog>) {
    val dog = Dog()
    zoom.adoption(dog)
}
//如上所示，我们可以把泛型类声明为不型变的，但是在使用它的时候，加上out或者in，让它在使用的时候产生型变。
//但是正如上面所示，function8函数内，绝对不能调用Zoom的adoption这种泛型参数包含在函数参数内的函数，而function9中也绝对不能调用release这种将泛型参数包含在返回值类型中的函数，理由已经在协变和逆变两个小节中介绍过了。
//
//使用点变形可以让我们的代码更加灵活，特别是对既需要泛型参数作为函数参数类型又需要泛型参数作为函数返回值类型的类而言。



fun main(args: Array<String>) {
    val dogZoom = Zoom9(Dog())
    function8(dogZoom)
    function9(dogZoom)
}






















































