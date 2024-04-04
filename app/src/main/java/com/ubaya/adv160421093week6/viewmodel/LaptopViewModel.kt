package com.ubaya.adv160421093week6.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.adv160421093week6.model.Laptop

class LaptopViewModel(application: Application): AndroidViewModel(application) {
    val LaptopLD = MutableLiveData<ArrayList<Laptop>>()
    val LaptopLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        LaptopLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/laptops.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Laptop>>() { }.type
                val result = Gson().fromJson<List<Laptop>>(it, sType)
                LaptopLD.value = result as ArrayList<Laptop>?
                loadingLD.value = false

                Log.d("show_volley", it)
            },
            {
                Log.e("show_volley", it.toString())
                LaptopLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}