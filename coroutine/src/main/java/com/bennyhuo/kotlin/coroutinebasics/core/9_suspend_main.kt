package com.bennyhuo.kotlin.coroutinebasics.core

//public static final Object main0(@NotNull Continuation $completion) {
//    return Unit.INSTANCE;
//}
//需要Continuation
//suspend函数需要传入一个Continuation，返回值是Any,这里是object，真正挂起是返回挂起标志，否则是返回返回值
suspend fun main() {
    println("hello")
}
//public static void main(String[] var0) {
//    RunSuspendKt.runSuspend(new _9_suspend_mainKt$$$main(var0));
//}


