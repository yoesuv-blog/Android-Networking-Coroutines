package com.yoesuv.mycoroutines.networks.repositories

import android.content.Context
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.Network
import com.yoesuv.mycoroutines.networks.ServiceFactory
import kotlinx.coroutines.CoroutineScope

class MainRepository(viewModelScope: CoroutineScope) {

    private val network = Network(viewModelScope)
    private val restApi = ServiceFactory.create()

    fun getListPlace(context: Context, onSuccess: (ListPlaceModel?) -> Unit, onFinally:(Boolean) -> Unit) {
        network.request(context, {
            restApi.getListPlace()
        }, {
            onSuccess(it)
        }, {
            onFinally(true)
        })
    }

}