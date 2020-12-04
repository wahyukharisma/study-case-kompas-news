package com.example.myapplication.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.network.model.Article
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val items: MutableList<Article>, private val listener: (Article) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name = view.findViewById<TextView>(R.id.article_list_title)
        private val image = view.findViewById<ImageView>(R.id.article_list_image)
        private val category = view.findViewById<TextView>(R.id.article_list_category)
        private val time = view.findViewById<TextView>(R.id.article_list_time)

        fun bindItem(items: Article, listener: (Article) -> Unit) {
            name.text = items.post_title
            category.text = items.category[0].name.toString()
            time.text = items.post_date
            let { Picasso.get().load("https://images-akamai-kompas-id.azureedge.net/wp-content/uploads//2020/01/20200120INA12_1579525459.jpg").fit().into(image) }
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}