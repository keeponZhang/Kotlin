package com.keepon.kotlin.chapter5

/**
 * createBy	 keepon
 */
data class Person(val name:String,val age:Int){
    fun getAge2():Int{
       return age;
    }
}

fun main(args: Array<String>) {
    val personlist = listOf<Person>(Person("alice",22), Person("keeon",22))
    println(personlist
            .maxBy() {it-> it.age })  //it相当于Lambda表达式输入参数，it.age相当于Lambda表达式返回值
}

//这上面的例子用到了集合上的maxBy函数，它只需要一个实参：一个函数，指定比较哪个值来找到最大的元素，花括号中的代码{ it.age }就是实现了这个逻辑的lambda，它接收一个集合中的元素作为实参（使用it引用它）并且返回用来比较的值，在上面的例子中：
//
//集合元素是Person对象
//用来比较的值是存储在其age属性中的值
//如果lambda刚好是 函数或者属性的委托，可以用 成员引用 替换。
//
fun test(){
    val people = listOf<Person>(Person("alice",22), Person("keeon",22))
    people.maxBy(Person :: age)
}


















