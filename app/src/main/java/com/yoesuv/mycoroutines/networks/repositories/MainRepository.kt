package com.yoesuv.mycoroutines.networks.repositories

import android.content.Context
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.Network
import com.yoesuv.mycoroutines.networks.ServiceFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class MainRepository(private val viewModelScope: CoroutineScope) {

    private val restApi = ServiceFactory.create()

    fun getListPlace(context: Context, onSuccess: (ListPlaceModel?) -> Unit, onFinally:(Boolean) -> Unit) {
        viewModelScope.launch {
            Network.request(context, restApi.getListPlace(), {
                onSuccess(it)
            }, {
                onFinally(true)
            })
        }
    }

}