package com.keepon.kotlin.chapter6

/**
 * createBy	 keepon
 */
//处理可空对象
//安全调用运算符?.把一次null检查和一次方法调用合并成一个操作。
fun  printAllCaps(s:String?){
    val  allCaps:String? = s?.toUpperCase();
    println(allCaps)
}

//处理可空属性
//安全调用不光可以调用方法，也能用来访问属性。
class Employee(val name:String,val manager:Employee?)
fun managerName(employee: Employee):String? = employee.manager?.name


fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)


    val ceo = Employee("DaBoss",null)
    val developer = Employee("Bob smith",ceo)
    println(managerName(ceo))
    println(managerName(developer))
}













