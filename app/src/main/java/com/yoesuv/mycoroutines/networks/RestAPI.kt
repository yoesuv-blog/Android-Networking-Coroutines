package com.yoesuv.mycoroutines.networks

import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface RestAPI {
    @GET("Sample.json")
    fun getListPlace():Deferred<ListPlaceModel>
}