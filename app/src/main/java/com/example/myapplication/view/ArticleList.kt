package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.network.model.Articles
import com.example.myapplication.viewModel.ArticleListViewModel

class ArticleList : AppCompatActivity() {
    private lateinit var viewModel : ArticleListViewModel
    private var items: MutableList<Articles> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        val list = findViewById<RecyclerView>(R.id.artilce_list_wrapper)
        viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        viewModel.getArticleList()

        viewModel.articleList.observe(this, Observer {
            Log.d("listobserve", it.articles[0].post_title)
            list.layoutManager = LinearLayoutManager(this)
            list.adapter = RecyclerViewAdapter(this, it.articles)
        })
    }
}