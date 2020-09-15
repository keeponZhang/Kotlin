package com.kotlin.action.ch06.action.可空类性的扩展


/**
 *createBy keepon
 */

//这一节展示了一些意外的状况。如果你没有使用额外的检查来解引用一个变量，
//比如s.isNullOrBlank（），它并不会立即意味着变量是非空的：这个函数有可能
//是非空类型的扩展函数。