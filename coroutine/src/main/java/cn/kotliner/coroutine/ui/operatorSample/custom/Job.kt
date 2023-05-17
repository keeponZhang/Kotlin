package cn.kotliner.coroutine.ui.operatorSample.custom

class Job(override var name: String = "") : CoroutineContext.Element {
    companion object Key : CoroutineContext.Key<Job>

    override val key: CoroutineContext.Key<*> get() = Job

}