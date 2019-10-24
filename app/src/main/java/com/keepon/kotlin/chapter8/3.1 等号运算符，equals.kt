package com.keepon.kotlin.chapter8

/**
 * createBy	 keepon
 */

//如果在Kotlin中使用==/!=运算符，它将被转换成equals方法的调用，和其他运算符不同的是，==和!=可以用于可空运算数，
//比较a == b会检查a是否为非空，如果不是就调用a.equals(b)，完整的调用如下所示：
//a?.equals(b) ?: (b == null)

data class Point3(val x:Int ,val y:Int){
    override fun equals(obj:Any?):Boolean{
//        比较obj == this会检查a是否为非空，类似a?.equals(b) ?: (b == null)
        if(obj == this){
            return true
        }
        if(obj !is Point) return false
        return obj.x == x &&obj.y==y
    }

}
//比较是否指向同一对象的引用，如果是，那么直接返回true
//类型如果不同，直接返回false
//比较作为判断依据的字段

//equals函数之所以被标记为override，这是因为这个方法的实现是在Any类中定义的，
//而operator关键字在基本方法中已经标记了。同时，equals不能实现为扩展函数，
//因为继承自Any类的实现始终优先于扩展函数。



