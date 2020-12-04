package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.network.model.Article
import com.example.myapplication.repository.ArticleListRepository

class ArticleListViewModel(application: Application) : AndroidViewModel(application) {
    private val _repository = ArticleListRepository(application)

    val articleList : LiveData<List<Article>>

    init {
        this.articleList = _repository.articleList
    }

    fun getArticleList() = _repository.getDataArticle()
}