package com.yoesuv.mycoroutines.menu.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.repositories.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mainRepository = MainRepository(viewModelScope)
    var liveDataListPlace: MutableLiveData<MutableList<ListPlaceModel.PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListPlace() {
        isLoading.postValue(true)
        mainRepository.getListPlace({
            liveDataListPlace.postValue(it?.data)
        },{ code, raw ->
            Log.e("result_error","unSuccessFul")
            Log.e("result_error","unSuccessFul # code $code")
            Log.e("result_error","unSuccessFul # raw ${raw?.string()}")
        },{
            Log.e("result_error","Throwable")
            it.printStackTrace()
        },{
            Log.d("result_debug","finally")
            isLoading.postValue(false)
        })
    }

}