package com.example.jetpacktest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    private val userLiveData = MutableLiveData<User>()

    //userName添加观察者的时候，会触发MediatorLiveData，onActive，触发Source.plug()
    // ，从而触发addSource里面的observer的onChange方法（userName是调用的时候触发一次）
    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
        Log.e("TAG", "MainViewModel  map:" );
        "${user.firstName} ${user.lastName}"
    }

    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        //这里其实就调用了setValue
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

    private val userIdLiveData = MutableLiveData<String>()

    // 注意，这个方法也很重要   activeStateChanged(boolean )，传true会发送更新事件，数据为data
    //返回的relsutLiveData观察了两个（本来是一个，userIdLiveData改变之后就变成了2个），result
    // .addSource与最终观察的无关，只会影响onChanged的类型(onChanged里面会调用多一次addSource方法，hasActiveObservers()
    // 大于0，会直接触发第二个source的onChanged方法，每次改变的时候，如果存在第二个source，会移除掉)
    //(注意,user是MediatorLiveData(可以观察不一样的)，所以订阅逻辑需要去MediatorLiveData看，这个订阅会触发里面source的订阅）
    val user: LiveData<User> = Transformations
            .switchMap(userIdLiveData) { userId ->
                Log.e("TAG", "MainViewModel  switchMap:" );
                Repository.getUser(userId)
            }

    // Function{   O apply(I input);} I为输入类型，O为输出类型
    //Transformations.map()的原理比较简单，返回的LiveData是对mapFunction.apply(x)返回的结果
    //感兴趣的，userLiveData发生改变时，返回的LiveData会收到回调(里面的Source用到了代理)，然后就调用了setValue
    val user2: LiveData<User> = Transformations.map(userLiveData) { user ->
        User(user.id.toString(), user.id.toString(), 0)
    }



    private val refreshLiveData = MutableLiveData<Any?>()

    val refreshResult = Transformations.switchMap(refreshLiveData) {
        Repository.getUser("")
    }

    fun refresh() {
        refreshLiveData.value = refreshLiveData.value
    }

    fun changeUser(index: Long) {
        val user1 = User("keepon" + index, "my", 1, index)
        userLiveData.value = user1
    }

    fun changeUserId(id: String) {
        userIdLiveData.value = id
    }
}