package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.RecyclerViewAdapter
import com.example.myapplication.network.model.Article
import com.example.myapplication.viewModel.ArticleListViewModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso

class ArticleList : AppCompatActivity() {
    private lateinit var viewModel : ArticleListViewModel
    private var items: MutableList<Article> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)
        val list = findViewById<RecyclerView>(R.id.artilce_list_wrapper)
        viewModel = ViewModelProvider(this).get(ArticleListViewModel::class.java)
        viewModel.getArticleList()
//        initData()

//        list.layoutManager = LinearLayoutManager(this)
//        list.adapter = RecyclerViewAdapter(this, items) {
//            startActivity(Intent(this, DetailNews::class.java))
//        }
    }
    private fun initData(){
//        val name = resources.getStringArray(R.array.club_name)
//        val image = resources.obtainTypedArray(R.array.club_image)
//        items.clear()
//        for (i in name.indices) {
//            items.add(Item(name[i],
//                    image.getResourceId(i, 0)))
//        }

        items.clear()

        viewModel.articleList.observe(this, Observer {
//            kenapa log ini ga mau muncul
//            Log.i("dsda", it.toString())

//            items.add(it)
        })
    }
}