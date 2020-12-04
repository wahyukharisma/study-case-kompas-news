package com.example.myapplication.adapter
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.network.model.Article
import com.example.myapplication.network.model.Articles
import com.example.myapplication.view.DetailNews
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val items: List<Article>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bindItem(items[position])
        holder.name.text = items[position].post_title
        holder.category.text = items[position].category[0].name.toString()
        holder.time.text = items[position].post_date
        Picasso.get().load("https://images-akamai-kompas-id.azureedge.net/wp-content/uploads//2020/01/20200120INA12_1579525459.jpg").into(holder.image)

        holder.name.setOnClickListener {
            val intent = Intent(context, DetailNews::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val name: TextView = view.findViewById(R.id.article_list_title)
        val image = view.findViewById<ImageView>(R.id.article_list_image)
        val category = view.findViewById<TextView>(R.id.article_list_category)
        val time = view.findViewById<TextView>(R.id.article_list_time)

//        fun bindItem(items: Article) {
//            name.text = items.post_title
//            category.text = items.category[0].name.toString()
//            time.text = items.post_date
//            Picasso.get().load("https://images-akamai-kompas-id.azureedge.net/wp-content/uploads//2020/01/20200120INA12_1579525459.jpg").into(image)
////            itemView.setOnClickListener {
////                listener(items)
////            }
//        }
    }
}