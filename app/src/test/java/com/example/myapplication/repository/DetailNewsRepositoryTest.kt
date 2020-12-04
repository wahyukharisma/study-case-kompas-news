package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.network.ApiNews
import com.example.myapplication.network.model.DetailsNews
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.runBlocking
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*

class DetailNewsRepositoryTest {

    @Mock
    var services = ApiNews.retrofitServices


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun fetchDetailRepo(){
        val detail: MutableList<DetailsNews> = mutableListOf()
        val response = services.getDetailNews()

        runBlocking {
            Mockito.`when`(services)
        }
    }
}