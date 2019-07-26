package com.yoesuv.mycoroutines.menu.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.repositories.MainRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val mainRepository = MainRepository()
    var liveDataListPlace: MutableLiveData<MutableList<ListPlaceModel.PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListPlace() {
        isLoading.postValue(true)
        viewModelScope.launch {
            mainRepository.getListPlace({ listPlaceModel ->
                isLoading.postValue(false)
                liveDataListPlace.postValue(listPlaceModel?.data)
            }, { code, response ->
                isLoading.postValue(false)
                Log.e("result_error","code $code body ${response?.string()}")
            }, {
                isLoading.postValue(false)
            })
        }
    }

}