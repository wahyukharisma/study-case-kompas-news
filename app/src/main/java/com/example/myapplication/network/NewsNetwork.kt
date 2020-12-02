package com.example.myapplication.network

import com.example.myapplication.network.model.DetailsNews
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://dennisgon.free.beeceptor.com/"

interface NewsNetwork {
    @GET("presiden-ingatkan-kepala-daerah-untuk-cegah-memburuknya-pandemi")
    fun getDetailNews() : Call<DetailsNews>
}