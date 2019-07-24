package com.yoesuv.mycoroutines.networks

import kotlinx.coroutines.*

object Network {

    fun <T> request(call: T, onSuccess: (T)-> Unit, onError:(Throwable) -> Unit) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                onSuccess(call)
            } catch (error: Throwable) {
                onError(error)
            }
        }
    }

}