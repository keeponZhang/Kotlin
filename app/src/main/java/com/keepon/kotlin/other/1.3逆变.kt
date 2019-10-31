package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
//协变的理解可能有点绕，不过如果上一小节你完全看懂了，这一小节就会非常简单，因为你可以看作逆变就是协变完全相反的存在。
//
//我们刚才看到了当Zoom是协变的时候，即Zoom声明成Zoom<out T>时，Zoom<Dog>是Zoom<Animal>的子类型；现在来看看逆变的情况，当Zoom是逆变的时候，
//即Zoom声明成Zoom<in T>的时候，Zoom<Animal>是Zoom<Dog>的子类型。
//
//看起来也许你又会疑惑，Animal明明是Dog的父类，为什么Zoom<Animal>变成了Zoom<Dog>的子类型？
//
//还记得刚才收养和放生两个方法吗？现在Zoom从协变变成了逆变，所以release()方法变得不是类型安全了，而adoption则变成了标准的合法的方法声明形式。我们来看一个例子：

open abstract class Zoom5<in T>(t: T) {
    //收养
    abstract fun adoption(t: T)
    //放生，这个方法声明是错的
//    abstract fun release(): T
}

class Zoom6( animal: Animal) : Zoom5<Animal>(animal){
    override fun adoption(t: Animal) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun release(): Animal {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

}

fun function5(zoom: Zoom5<Dog>) {
    val dog = Dog()
    zoom.adoption(dog)
}

fun function6(zoom: Zoom5<Dog>) {
//    val dog: Dog = zoom.release()
}

//来看function5函数的定义，function5接收一个Zoom<Dog>类型的参数，然后创建了一个Dog对象，并把它作为参数，传给了zoom的adoption()方法 ——
//一个狗主题的动物园收养了一条狗，非常符合逻辑；现在，由于Zoom是逆变的，所以Zoom<Animal>是Zoom<Dog>的子类型，所以animalZoom可以作为参数传递给函数function，这时候来看看function的执行情况 —— 一个普通的动物园收养了一只狗 —— 这在现实中非常符合逻辑，在编程中也是类型安全的。


fun main(args: Array<String>) {
    val animalZoom = Zoom6(Animal())
    //现在由于逆变，Zoom<Animal>是Zoom<Dog>的子类型
    function5(animalZoom)

    function6(animalZoom)
}

//function6函数仍然接收一个Zoom<Dog>类型的参数，由于Zoom是逆变的，所以Zoom<Animal>是Zoom<Dog>的子类型，所以将animalZoom作为参数传入function是合法的；到目前为止和上面没有什么不同，但是再来看看function的执行情况：一个Dog类型的变量接收了zoom的release()方法的返回值......
//现在情况发生变化了，animalZoom调用release方法返回的对象，可能是一个任意类型的Animal，比如说Cat，所以这里一定会发生编译错误，因为我们将一个父类型的对象赋值给了子类型的引用，这是完全错误的；想想看，假如你有一只猫，但你却一定要把它当成狗......简直不可思议。
//
//因此，当Zoom类是逆变的时候，它的内部就不能存在一个有包含泛型参数T存在于返回值类型的函数。
//
//我们由此得到了逆变的命题；
//命题3：存在两个类Son和Dad，且Son : Dad；存在泛型类A<in T>，则类型A<Dad>是类型A<Son>的子类型，且A<in T>中不存在包含T作为返回值类型（或作为返回值类型的泛型参数）的函数






































