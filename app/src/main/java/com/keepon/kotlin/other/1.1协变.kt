package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
//问题：在开胃菜里，Dog是Animal的子类，那Zoom<Dog>是不是Zoom<Animal>的子类型？
//答案：Zoom<Dog>和Zoom<Animal>没有任何继承关系。

//看起来有点不可思议，但是想想现实中的情况：如果我想要一只动物作为宠物，我对你到底送给我哪一种动物实际上无所谓，
//哪怕是大象狮子，或是蓝鲸大白鲨都可以，这时，你给了我一条狗，狗当然是动物的一种，所以我将狗作为宠物这个行为和我的预期并不冲突。
//但是Zoom<Dog>和Zoom<Animal>的情况并非如此，Zoom<Animal>不是代表所有类型的动物园的抽象，而是代表那种含有各种动物的动物园，
//而Zoom<Dog>可能代表一种狗主题的动物园，这是两种完全不同的动物园，如果你只想去动物园看各种类型的狗，那去那种普通的动物园可能并不符合你的预期，
//因为狗在这种动物园只是很小的一部分，而且还有可能它虽然有各种动物，但是根本就没有狗。
//
//编程实际上比现实更为抽象，所以我们回到编程中来；这里我们要阐述清楚几个容易混淆的概念 —— 类和类型；Dog是一个类，也是一种类型，
//而Zoom是一个类，但Zoom不是一种类型，因为Zoom是一个泛型类，而Zoom<Animal>或Zoom<Dog>则都是类型，而且是两种没有继承关系的，独立的类型，我们得到了第一个命题：
//
//命题1: 存在两个类Son和Dad，且Son : Dad；存在泛型类A<T>，则类型A<Dad>和类型A<Son>之间没有任何子类型化关系。
//
//如果我们一定让Zoom<Dog>被看作是Zoom<Animal>的子类型，也是有办法的，那就是在Zoom声明的时候使用out修饰符：

open abstract class Zoom2<out T>(t: T){
    //这里只是简单举例，Zoom类的方法的实现就省略了

    //收养，这个方法声明是错的
//    abstract  fun adoption(t: T)
    //放生
    abstract fun release(): T
}



//这就是协变：泛型类的继承关系来源于子类型的继承关系，但这不是没有任何限制的......
//如果一个泛型类是协变的，那泛型参数类型的对象，只能出现在Zoom类中函数的返回值的位置上，
//不能出现在函数的参数里；我们来给Zoom加几个方法来说明这一点：


fun function(zoom: Zoom2<Animal>) {
    //具体动物不清楚，可能是狮子
    val animal = Animal()
//    zoom.adoption(animal)
}
fun function2(zoom: Zoom2<Animal>) {
    val animal: Animal = zoom.release()
}

class Zoom3( animal: Animal) : Zoom2<Animal>(animal){
//    override fun adoption(t: Animal) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun release(): Animal {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
//有趣的问题出现了，函数function接收一个Zoom<Animal>类型的参数，但是由于Animal是协变的，所以我们可以把Zoom<Dog>作为参数传入。但实际上这真的安全吗？
fun main(args: Array<String>) {
    //狗主题公园
    val dogZoom = Zoom3(Dog())
    //狗主题公园可能收养了狮子
    function(dogZoom)

//    上面的代码是完全合法的，因为dogZoom调用release方法会返回Dog，而Dog是Animal的子类，所以给animal引用赋值为一个Dog是完全合法的
    function2(dogZoom)
}

//我们看看function是如何定义的，它创建了一个Animal类型的对象，并把它收养到Zoom<Animal>中，但是现在参数的是Zoom<Dog>；所以，如果这么做的话，
//一个狗主题的动物园可能收养了一只非洲雄狮，想想可怜的狗狗们会遭受怎样的命运......所以当Zoom如果是协变的时候，
//像adoption这种把泛型参数作为方法参数的类型的方法是不应该存在的，因为它类型不安全；我们慢慢继续，先忘掉我们有adoption()方法，
//现在的Zoom应该是这样的：

//我们总结一下协变的命题；
//命题2：存在两个类Son和Dad，且Son : Dad；存在泛型类A<out T>，则类型A<Son>是类型A<Dad>的子类型，且A<out T>中不存在包含T作为参数类型
//（或作为参数类型的泛型参数）的函数。













