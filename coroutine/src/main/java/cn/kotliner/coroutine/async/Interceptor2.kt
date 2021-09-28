package cn.kotliner.coroutine.async

/**
 * createBy	 keepon
 */
//这里为什么会报错呢，因为是实现接口，构造函数不用带参数，所以只能复写key,即Interceptor2(override val key: CoroutineContext.Key<*>) :
// ContinuationInterceptor {
// class Interceptor2(ContinuationInterceptor) : ContinuationInterceptor {
//    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
//        return UiCotinuationWrapper(continuation)
//    }
//}