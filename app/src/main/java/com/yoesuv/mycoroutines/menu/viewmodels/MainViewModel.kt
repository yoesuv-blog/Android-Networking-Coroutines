package com.yoesuv.mycoroutines.menu.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
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

    fun getListPlace() {
        launch {
            mainRepository.getListPlace({ listPlaceModel ->
                Log.d("result_debug","data count : ${listPlaceModel?.data?.size}")
            }, {

            }, {

            })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}