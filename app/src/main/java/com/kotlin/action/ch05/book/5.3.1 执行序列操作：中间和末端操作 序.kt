package com.kotlin.action.ch05.book.执行序列操作


/**
 *createBy keepon
 */
//序列操作分为两类：中间的和末端的。一次中间操作返回的是另一个序列，这
//个新序列知道如何变换原始序列中的元素。而一次末端操作返回的是一个结果，这
//个结果可能是集合、元素、数字，或者其他从初始集合的变换序列中获取的任意对象
//asSequence.map.filter是中间操作，toList是末端操作
//listOf(1, 2, 3, 4).asSequence()
//.map { print("map($it) "); it * it }
//.filter { print("filter($it) "); it % 2 == 0 }
//.toList()

//中间操作始终都是惰性的
//执行这段代码并不会在控制台上输出任何内容。这意味着map 和filter 变换
//被延期了，它们只有在获取结果的时候才会被应用（ 即末端操作被调用的时候）：
//listOf(1, 2, 3, 4).asSequence() .map { print("map($it) "); it * it } .filter { print("filter($it) "); it % 2 == 0 }
//末端操作触发执行了所有的延期计算。

//这个例子中另外一件值得注意的重要事情是计算执行的顺序。一个笨办法是先
//在每个元素上调用map 函数，然后在结果序列的每个元素上再调用filter 函数。
//map 和filter 对集合就是这样做的，而序列不一样。对序列来说，所有操作是按
//顺序应用在每一个元素上：处理完第一个元素（先映射再过滤），然后完成第二个
//元素的处理，以此类推。
//这种方法意味着部分元素根本不会发生任何变换，如果在轮到它们之前就己经
//取得了结果。我们来看一个map 和find 的例子。首先把一个数字映射成它的平方，
//然后找到第一个比数字3 大的条目：
//println(listOf(l, 2, 3, 4) .asSequence().map {it* it }.find {it > 3 })
//
//如果同样的操作被应用在集合而不是序列上时，那么map 的结果首先被求出来，
//即变换初始集合中的所有元素。第二步，中间集合中满足判断式的一个元素会被找
//出来。而对于序列来说，惰性方法意味着你可以跳过处理部分元素。图5.8 阐明了
//这段代码两种求值方式之间的区别， 一种是及早求值（使用集合）， 一种是惰性求
//值（使用序列）。
//
//
//
//第一种情况，当你使用集合的时候，列表被变换成了另一个列表，所以map 变
//换应用到每一个元素上，包括了数字3 和4 。然后，第一个满足判断式的元素被找到了：
//数字2 的平方。
//第二种情况， find 调用一开始就逐个地处理元素。从原始序列中取一个数字，
//用map 变换它，然后再检查它是否满足传给find 的判断式。当进行到数字2 时，
//发现它的平方己经比数字3 大，就把它作为find 操作结果返回了。不再需要继续检
//查数字3 和4 ，因为这之前你己经找到了结果。
//在集合上执行操作的顺序也会影响性能。假设你有一个人的集合，想要打印集
//合中那些长度小于某个限制的人名。你需要做两件事： 把每个人映射成他们的名字，
//然后过滤掉其中那些不够短的名字。这种情况可以用任何顺序应用map 和filt er
//操作。两种Jil页序得到的结果一样，但它们应该执行的变换总次数是不一样的，如图5 . 9
//所示。













