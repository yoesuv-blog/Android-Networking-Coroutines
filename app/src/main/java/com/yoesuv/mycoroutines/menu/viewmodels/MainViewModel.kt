package com.yoesuv.mycoroutines.menu.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.yoesuv.mycoroutines.menu.models.ListPlaceModel
import com.yoesuv.mycoroutines.networks.repositories.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val mainRepository = MainRepository()
    var liveDataListPlace: MutableLiveData<MutableList<ListPlaceModel.PlaceModel>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getListPlace() {
        isLoading.postValue(true)
        launch {
            mainRepository.getListPlace({ listPlaceModel ->
                isLoading.postValue(false)
                liveDataListPlace.postValue(listPlaceModel?.data)
            }, {
                isLoading.postValue(false)
            }, {
                isLoading.postValue(false)
            })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}