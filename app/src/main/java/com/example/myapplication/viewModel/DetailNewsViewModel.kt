package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.network.model.DetailsNews
import com.example.myapplication.repository.DetailNewsRepository

class DetailNewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _repository = DetailNewsRepository(application)
    val detailNews : LiveData<DetailsNews>
    val progressBar : LiveData<Boolean>

    init {
        this.detailNews = _repository.detailNews
        this.progressBar = _repository.progressBar
    }

    fun getDetailNews() = _repository.getDataNews()
}