package com.yoesuv.mycoroutines.networks.repositories

import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.Network
import com.yoesuv.mycoroutines.networks.ServiceFactory
import retrofit2.Response

class MainRepository {

    private val restApi = ServiceFactory.create()

    suspend fun getListPlace(onSuccess: (ListPlaceModel?) -> Unit, onUnSuccessful:(Response<ListPlaceModel>) -> Unit, onError: (Throwable) -> Unit) {
        Network.request(restApi.getListPlace(), {
            if (it.isSuccessful) {
                onSuccess(it.body())
            } else {
                onUnSuccessful(it)
            }
        },{
            onError(it)
        })
    }

}