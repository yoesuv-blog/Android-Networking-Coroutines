package com.yoesuv.mycoroutines.networks

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit2.Response


object Network {

    fun <T> request(context: Context, response: Response<T>, onSuccess:(T?) -> Unit, onFinally:(Boolean) -> Unit){
        try {
            if (response.isSuccessful) {
                Log.d("result_debug","Network # isSuccessful")
                onSuccess(response.body())
            } else {
                Log.e("result_error","Network # UnSuccessFul")
                Log.e("result_error","Network # code : ${response.code()}")
                Log.e("result_error","Network # body : ${response.errorBody()?.string()}")
                Toast.makeText(context, "UnSuccessFul # ${response.code()}", Toast.LENGTH_SHORT).show()
            }
        } catch (throwable: Throwable) {
            Log.e("result_error","Network # Throwable")
            Log.e("result_error","Network # message : ${throwable.message}")
            Toast.makeText(context, "Throwable # ${throwable.message})}", Toast.LENGTH_SHORT).show()
            throwable.printStackTrace()
        } finally {
            onFinally(true)
        }
    }

}