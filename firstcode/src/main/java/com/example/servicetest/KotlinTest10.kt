package com.example.servicetest

/**
 * createBy	 keepon
 */
fun handMydata(data: SimpleData<Person>) {
    val personData = data.get()
}

fun handSimpledata(data: SimpleData2<Person>) {
    val teacher = Teacher(10)
    data.set(teacher)
}

fun main(args: Array<String>) {
//    val student2 = Student(19)
//    //已经进行了
//    val data2 = SimpleData2<Student>()
//    data2.set(student2)
//    //实际这行代码会报错，之类假设它能编译通过
//    handSimpledata(data2)
//    val studentData2 = data2.get()


    val student = Student(19)
    //已经进行了
    val data = SimpleData<Student>(student)
    handMydata(data)
    val studentData = data.get()
    println(studentData)
}