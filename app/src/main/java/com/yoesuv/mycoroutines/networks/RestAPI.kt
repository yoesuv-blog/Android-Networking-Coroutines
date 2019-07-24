package com.yoesuv.mycoroutines.networks

import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import retrofit2.Response
import retrofit2.http.GET

interface RestAPI {
    @GET("Sample.json")
    suspend fun getListPlace():Response<ListPlaceModel>
}