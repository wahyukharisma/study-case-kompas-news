package com.example.myapplication.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemListBinding
import com.example.myapplication.network.model.Article
import com.example.myapplication.view.DetailNews
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val items: List<Article>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.articleListTitle.text = items[position].post_title
            binding.articleListCategory.text = items[position].category[1].name.toString()
            binding.articleListTime.text = items[position].post_date
            Picasso.get().load("https://images-akamai-kompas-id.azureedge.net/wp-content/uploads//2020/01/20200120INA12_1579525459.jpg").into(binding.articleListImage)

            binding.articleListTitle.setOnClickListener {
                val intent = Intent(context, DetailNews::class.java)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemListBinding.bind(view)

//        val name: binding.articleListTitle
//        val image = view.findViewById<ImageView>(R.id.article_list_image)
//        val category = view.findViewById<TextView>(R.id.article_list_category)
//        val time = view.findViewById<TextView>(R.id.article_list_time)
    }
}