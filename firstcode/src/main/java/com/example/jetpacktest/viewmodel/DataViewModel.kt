package com.example.jetpacktest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bennyhuo.kotlin.coroutines.utils.log
import org.omg.PortableInterceptor.Interceptor
import retrofit2.converter.gson.GsonConverterFactory

/**
 * createBy	 keepon
 */
class DataViewModel(val id: Int) : BaseViewModel() {

    private val resultInternal = MutableLiveData<String>()
    val result: LiveData<String> = resultInternal

    fun requestData(dataID: Int): LiveData<String> {
        launchOnMain {
            val response = RetrofitClient.getXXX.getXXX(1)
            if (response.isSuccess) {
                resultInternal.value = response.data.toString()
            }
        }
        return result
    }
}
