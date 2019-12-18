package ch04.ex1_4_2_InnerAndNestedClasses1

class Outer {
    inner class Inner {
//       需要使用this@Outer 从Inner 类去访问Outer 类
        fun getOuterReference(): Outer = this@Outer
    }
}
