import androidx.arch.core.util.Function
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

fun <X, Y> switchMapMy(
    source: LiveData<X>,
    switchMapFunction: Function<X, LiveData<Y>>
): LiveData<Y> {
    val result = MediatorLiveData<Y>()
    result.addSource(source, object : Observer<X> {
        var mSource: LiveData<Y>? = null
        override fun onChanged(x: X) {
            val newLiveData = switchMapFunction.apply(x)
            if (mSource === newLiveData) {
                return
            }
            if (mSource != null) {
                result.removeSource(mSource!!)
            }
            mSource = newLiveData
            if (mSource != null) {
                result.addSource(mSource!!
                ) { y -> result.value = y }
            }
        }
    })
    return result
}