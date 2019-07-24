package com.yoesuv.mycoroutines.networks.repositories

import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.Network
import com.yoesuv.mycoroutines.networks.ServiceFactory

class MainRepository {

    private val restApi = ServiceFactory.create()

    suspend fun getListPlace(onSuccess: (ListPlaceModel?) -> Unit, onError: (Throwable) -> Unit) {
        Network.request(restApi.getListPlace(), {
            if (it.isSuccessful) {
                onSuccess(it.body())
            } else {

            }
        },{
            onError(it)
        })
    }

}