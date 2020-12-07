package com.example.myapplication.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.ApiNews
import com.example.myapplication.network.model.DetailsNews
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailNewsRepository(val application: Application) {
    var detailNews = MutableLiveData<DetailsNews>()
    var shimmerBar = MutableLiveData<Boolean>()

    fun getDataNews(){
        shimmerBar.value = true

        ApiNews.retrofitServices.getDetailNews().enqueue(object : Callback<DetailsNews>{
            override fun onResponse(call: Call<DetailsNews>, response: Response<DetailsNews>) {
                shimmerBar.value = false
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                response.body()?.let {
                    detailNews.value = it
                }
            }

            override fun onFailure(call: Call<DetailsNews>, t: Throwable) {
                shimmerBar.value = false
                Toast.makeText(application,"Error while accesing the API", Toast.LENGTH_SHORT)
            }
        })
    }

}