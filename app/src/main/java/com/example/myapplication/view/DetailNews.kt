package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDetailNewsBinding
import com.example.myapplication.viewModel.DetailNewsViewModel
import com.squareup.picasso.Picasso

class DetailNews : AppCompatActivity() {

    private lateinit var _viewModel : DetailNewsViewModel
    private lateinit var _binding : ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        _viewModel = ViewModelProvider(this).get(DetailNewsViewModel::class.java)
        _viewModel.getDetailNews()

        _viewModel.detailNews.observe(this, Observer {
            _binding.tvTitle.text = it.post_title
            _binding.tvAuthor.text = it.author
            _binding.tvTime.text = it.post_date
            _binding.tvImageDescription.text = it.post_excerpt
            _binding.tvContent.text = it.post_content
            Picasso.get().load("https://images.unsplash.com/photo-1584582868986-db1781714c75?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80")
                .into(_binding.ivHeaderImage)
        })

        _viewModel.progressBar.observe(this, Observer {
            if(it){
                _binding.rlContent.visibility = View.GONE
                _binding.pbLoading.visibility = View.VISIBLE
            }else{
                _binding.rlContent.visibility = View.VISIBLE
                _binding.pbLoading.visibility = View.GONE
            }
        })
    }
}