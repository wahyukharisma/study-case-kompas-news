package com.example.myapplication.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.network.BASE_URL
import com.example.myapplication.network.NewsNetwork
import com.example.myapplication.network.model.Article
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleListRepository (val application: Application) {
    var articleList = MutableLiveData<List<Article>>()

    fun getDataArticle () {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        val services = retrofit.create(NewsNetwork::class.java)

        services.getArticleList().enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                Log.d("ArticleList", "Response : ${Gson().toJson(response.body())}")
                articleList.value = response.body()
                Toast.makeText(application,response.body().toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Toast.makeText(application,"Error while accesing the API", Toast.LENGTH_SHORT).show()
            }

        })
    }
}