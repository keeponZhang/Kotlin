package net.println.kotlin.chapter2

/**
 * Created by benny on 2/26/17.
 */

class 妹子(性格: String, 长相: String, 声音: String) : 人(22)
class 帅哥(性格: String, 长相: String, 声音: String) : 人(性格, 长相, 声音)

open class 人(var 性格: String, var 长相: String, var 声音: String) {
    init {
        println("new 了一个${this.javaClass.simpleName}, ta性格:$性格, 长相:$长相, 声音:$声音")
    }

    private var age: Int? = null;

    public constructor(age: Int) : this("", "", "") {
        this.age = age;
    }
}

open class Person {
    //没有主构造函数不用调用:this
    constructor() {
    }

    constructor(age: Int) {
    }
}

//constructor是可以省略的
class 妹子2(性格: String, 长相: String, 声音: String) {
    constructor(性格: String, 长相: String) : this(性格, 长相, "一般")
}

fun main(args: Array<String>) {
    val 我喜欢的妹子: 妹子 = 妹子("温柔", "甜美", "动人")
    val 我膜拜的帅哥: 帅哥 = 帅哥("彪悍", "帅气", "浑厚")
    println("我喜欢的妹子 is 人" + (我喜欢的妹子 is 人))
    妹子2("", "", "")
}