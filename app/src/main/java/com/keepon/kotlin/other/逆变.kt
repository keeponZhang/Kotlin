package com.keepon.kotlin.other

/**
 * createBy	 keepon
 */
协变的理解可能有点绕，不过如果上一小节你完全看懂了，这一小节就会非常简单，因为你可以看作逆变就是协变完全相反的存在。

我们刚才看到了当Zoom是协变的时候，即Zoom声明成Zoom<out T>时，Zoom<Dog>是Zoom<Animal>的子类型；现在来看看逆变的情况，当Zoom是逆变的时候，
即Zoom声明成Zoom<in T>的时候，Zoom<Animal>是Zoom<Dog>的子类型。






































