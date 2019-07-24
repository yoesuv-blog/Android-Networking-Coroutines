package com.yoesuv.mycoroutines.menu.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.yoesuv.mycoroutines.networks.repositories.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    var job: Job = Job()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val mainRepository = MainRepository()

    fun getListPlace() {
        launch {
            mainRepository.getListPlace({

            },{

            })
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

}