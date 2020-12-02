package com.example.myapplication.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.BASE_URL
import com.example.myapplication.network.NewsNetwork
import com.example.myapplication.network.model.DetailsNews
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailNewsRepository(val application: Application) {
    var detailNews = MutableLiveData<DetailsNews>()
    var progressBar = MutableLiveData<Boolean>()

    fun getDataNews(){
        progressBar.value = true
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

        val services = retrofit.create(NewsNetwork::class.java)

        services.getDetailNews().enqueue(object : Callback<DetailsNews>{
            override fun onResponse(call: Call<DetailsNews>, response: Response<DetailsNews>) {
                progressBar.value = false
                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                detailNews.value = response.body()
            }

            override fun onFailure(call: Call<DetailsNews>, t: Throwable) {
                progressBar.value = false
                Toast.makeText(application,"Error while accesing the API", Toast.LENGTH_SHORT)
            }

        })
    }
}