package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.viewModel.DetailNewsViewModel
import com.squareup.picasso.Picasso

class DetailNews : AppCompatActivity() {

    private lateinit var viewModel : DetailNewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        viewModel = ViewModelProvider(this).get(DetailNewsViewModel::class.java)
        viewModel.getDetailNews()

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvAuthor = findViewById<TextView>(R.id.tv_author)
        val tvTime = findViewById<TextView>(R.id.tv_time)
        val tvImageDescription = findViewById<TextView>(R.id.tv_imageDescription)
        val tvContent = findViewById<TextView>(R.id.tv_content)
        val ivHeader = findViewById<ImageView>(R.id.iv_headerImage)
        val pbLoading = findViewById<ProgressBar>(R.id.pb_loading)
        val rlContent = findViewById<RelativeLayout>(R.id.rl_content)

        viewModel.detailNews.observe(this, Observer {
            tvTitle.text = it.post_title
            tvAuthor.text = it.author
            tvTime.text = it.post_date
            tvImageDescription.text = it.post_excerpt
            tvContent.text = it.post_content
            Picasso.get().load("https://images.unsplash.com/photo-1606756790138-261d2b21cd75?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=701&q=80").into(ivHeader)
        })

        viewModel.progressBar.observe(this, Observer {
            if(it){
                rlContent.visibility = View.GONE
                pbLoading.visibility = View.VISIBLE
            }else{
                rlContent.visibility = View.VISIBLE
                pbLoading.visibility = View.GONE
            }
        })
    }
}