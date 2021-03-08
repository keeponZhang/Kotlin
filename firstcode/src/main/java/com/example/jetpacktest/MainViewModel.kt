package com.example.jetpacktest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(countReserved: Int) : ViewModel() {

    private val userLiveData = MutableLiveData<User>()

    val userName: LiveData<String> = Transformations.map(userLiveData) { user ->
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
    //返回的relsutLiveData观察了两个（本来是一个，userIdLiveData改变之后就变成了2个），result
    // .addSource与最终观察的无关，只会影响onChanged的类型
    val user: LiveData<User> = Transformations.switchMap(userIdLiveData) { userId ->
        Repository.getUser(userId)
    }

    // Function{   O apply(I input);} I为输入类型，O为输出类型
    //Transformations.map()的原理比较简单，返回的LiveData是对mapFunction.apply(x)返回的结果
    //感兴趣的，userLiveData发生改变时，返回的LiveData会收到回调(里面的Source用到了代理)，然后就调用了setValue
    val user2: LiveData<User> = Transformations.map(userLiveData) { user ->
        User(user.id.toString(), user.id.toString(), 0)
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }

    private val refreshLiveData = MutableLiveData<Any?>()

    val refreshResult = Transformations.switchMap(refreshLiveData) {
        Repository.getUser("")
    }

    fun refresh() {
        refreshLiveData.value = refreshLiveData.value
    }
}