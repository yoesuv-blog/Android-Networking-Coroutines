package com.yoesuv.mycoroutines.networks

import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import retrofit2.Response

class Network(private val coroutineScope: CoroutineScope) {

    fun <T> request(context: Context, response: suspend() -> Response<T>, onSuccess:(T?) -> Unit, onFinally:(Boolean) -> Unit) {
        coroutineScope.launch {
            try {
                val result = response()
               if (result.isSuccessful) {
                   Log.d("result_debug","Network # isSuccessful")
                   onSuccess(result.body())
               } else {
                   Log.e("result_error","Network # UnSuccessFul")
                   Log.e("result_error","Network # code : ${result.code()}")
                   Log.e("result_error","Network # body : ${result.errorBody()?.string()}")
                   Toast.makeText(context, "UnSuccessFul # ${result.code()}", Toast.LENGTH_SHORT).show()
               }
            } catch (throwable: Throwable) {
                Log.e("result_error","Network # Throwable")
                Toast.makeText(context, "Throwable # ${throwable.message})}", Toast.LENGTH_SHORT).show()
                throwable.printStackTrace()
            } finally {
                Log.d("result_debug","Network # finally")
                onFinally(true)
            }
        }
    }

}