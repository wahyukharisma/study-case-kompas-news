package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.network.model.Articles
import com.example.myapplication.repository.ArticleListRepository
import kotlinx.coroutines.launch

class ArticleListViewModel(application: Application) : AndroidViewModel(application) {
    private val _repository = ArticleListRepository(application)

    val articleList : LiveData<Articles>

    init {
        this.articleList = _repository.articleList
    }

    fun getArticleList() {
        viewModelScope.launch {
            _repository.getDataArticle()
        }
    }
}