package cn.kotliner.coroutine.ui.operatorSample

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.EmptyCoroutineContext


/**
 * Time:2023-05-07 下午 9:45
 * Author:
 * Description:
 */
fun main() {
    // plusCase1()
    // plusCase2()
    // plusCase3()
    // plusCase4()
    // plusCase5()
    minusCase5()
}

fun plusCase1() {
    //case1 plus(EmptyCoroutineContext)
    val case1 = Dispatchers.Main + EmptyCoroutineContext
    println("xiaozhan case1 $case1")
    // 结果: Dispatchers.Main

}

fun plusCase2() {
    //case2 相同类型的Element
    val case2 = CoroutineName(
        "c1"
    ) + CoroutineName("c2")
    println("xiaozhan case2 $case2")
    // 相同类型的直接替换掉。
}

fun plusCase3() {
    //case3 当前的CoroutineContext没有ContinuationInterceptor
    val case3 = CoroutineName("c1") + Job()
    println("xiaozhan case3 $case3")
    // CoroutineName("c1") <- Job。头插法被 plus 的 (Job)放在链表头部

}

fun plusCase4() {
    //case4 当前的CoroutineContext只有ContinuationInterceptor，
    val case4 = Dispatchers.Main + Job()
    println("xiaozhan case4 $case4")
    // Job <- Dispatchers.Main。虽然是头插法，但是 ContinuationInterceptor 必须在链表头部。
}

fun plusCase5() {
    //case4 当前的CoroutineContext只有ContinuationInterceptor，
    val case4 = Dispatchers.Main + Job()
    println("xiaozhan case4 $case4")
    //case5 当前的CoroutineContext有ContinuationInterceptor和其他

    val case5 = case4 + CoroutineName("c5")
    println("xiaozhan case5 $case5")
    case5.minusKey(Job)

    // 结果: Job <- CoroutineName("c5") <- Dispatchers.Main。Dispatchers.Main 在链表头部，其它的采用头插法。
}

fun minusCase5() {
    //case4 当前的CoroutineContext只有ContinuationInterceptor，
    val case4 = Dispatchers.Main + Job()
    println("xiaozhan case4 $case4")
    //case5 当前的CoroutineContext有ContinuationInterceptor和其他

    val case5 = case4 + CoroutineName("c5")
    println("xiaozhan case5 $case5")
    case5.minusKey(MyElement)

    // 结果: Job <- CoroutineName("c5") <- Dispatchers.Main。Dispatchers.Main 在链表头部，其它的采用头插法。
    // 1没找到节点：minusKey(MyElement)。在Job节点处走 newLeft === left 分支，依此类推，在CoroutineName处走同样的分支，在 Dispatchers.Main 处走同样的分支。
    // 2 节点在尾部：minusKey(Job)。在 CoroutineName("c5") 节点走 newLeft === EmptyCoroutineContext 分支，依此往头部递归
    // 3节点不在尾部：minusKey(CoroutineName)。在 Dispatchers.Main 节点处走 else 分支
}


// 如果不考虑Dispatchers.Main的情况。我们可以把+用<-代替。CoroutineName("c1") + Job()等价于CoroutineName("c1") <- Job