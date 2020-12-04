package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.model.DetailsNews
import com.example.myapplication.repository.DetailNewsRepository
import kotlinx.coroutines.launch

class DetailNewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _repository = DetailNewsRepository(application)
    val detailNews : LiveData<DetailsNews>
    val shimmerBar : LiveData<Boolean>

    init {
        this.detailNews = _repository.detailNews
        this.shimmerBar = _repository.shimmerBar
    }

    fun getDetailNews() {
        viewModelScope.launch {
            _repository.getDataNews()
        }
    }
}