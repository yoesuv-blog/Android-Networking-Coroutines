package com.yoesuv.mycoroutines.networks.repositories

import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.ServiceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MainRepository(private var viewModelScope: CoroutineScope) {

    private val restApi = ServiceFactory.create()

    fun getListPlace( onSuccess: (ListPlaceModel?) -> Unit, onUnSuccessFul:(Int, ResponseBody?) -> Unit, onError: (Throwable) -> Unit, onFinally:(Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val result = restApi.getListPlace()
                if (result.isSuccessful) {
                    onSuccess(result.body())
                } else {
                    onUnSuccessFul(result.code(), result.errorBody())
                }
            } catch (throwable: Throwable) {
                onError(throwable)
            } finally {
                onFinally(true)
            }
        }
    }

}