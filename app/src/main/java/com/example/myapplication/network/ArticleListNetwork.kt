package com.example.myapplication.network

import com.example.myapplication.network.model.Article
import retrofit2.Call
import retrofit2.http.GET

//const val BASE_URL = "https://dennisgon.free.beeceptor.com/"

interface ArticleListNetwork {
    @GET("articles")
    fun getArticleList() : Call<Article>
}