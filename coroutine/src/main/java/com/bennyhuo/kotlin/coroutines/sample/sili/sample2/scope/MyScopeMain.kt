package kotlinx.coroutines.scope

import com.bennyhuo.kotlin.coroutines.sample.sili.sample2.scope.MyScope
import kotlinx.coroutines.AbstractCoroutine
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * Time:2025/6/6 16:20
 * Author:
 * Description:
 */
fun main() = runBlocking {
    val scope = MyScope()

    //val block: suspend MyScope.() -> Unit = {
    //    // 这里的 `this` 是 MyScope 实例
    //    println("Accessing scope: ${this.name}")
    //    doWork() // 调用接收者的成员函数
    //}
    //
    //// 通过 start 方法启动协程（模拟内部实现）
    //val coroutine = object : AbstractCoroutine<Unit>(EmptyCoroutineContext) {}
    //coroutine.start(CoroutineStart.DEFAULT, scope, block)
}

//// 方式1：显式传递 scope（需要手动作为参数传递）
//val block1: suspend (MyScope) -> Unit = { scope ->
//    println(scope.name)
//    scope.doWork()
//}
//
//// 方式2：通过 receiver 隐式传递（直接访问 this）
//val block2: suspend MyScope.() -> Unit = {
//    println(name)  // 等价于 this.name
//    doWork()       // 等价于 this.doWork()
//}