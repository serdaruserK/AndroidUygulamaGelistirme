package com.example.haberlergrid
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.haberler.view.*
import kotlinx.android.synthetic.main.haberler.view.*

class HaberlerAdapter : BaseAdapter{
    var haberlist = ArrayList<Haberler>()
    var context: Context? = null

    constructor(context: Context, haberlist: ArrayList<Haberler>) : super() {
        this.context = context
        this.haberlist = haberlist
    }
    override fun getCount(): Int {
        return haberlist.size
    }

     override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val news = this.haberlist[position]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var newsView = inflator.inflate(R.layout.haberler, null)



        Picasso.get().load(news.urlToImage).into(newsView.imgNews);
        newsView.newsName.text = news.title!!

        newsView.setOnClickListener{
            var intent = Intent(context, haberler_entry::class.java)
            intent.putExtra("title",news.title!!)
            intent.putExtra("description",news.description!!)
            intent.putExtra("image", news.urlToImage)
            intent.putExtra("author",news.author)
            context!!.startActivity(intent)

        }

        return newsView

    }

     override fun getItem(position: Int): Any {
        return haberlist[position]
    }

     override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}