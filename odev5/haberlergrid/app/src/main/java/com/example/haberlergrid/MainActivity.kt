package com.example.haberlergrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    var adapter : HaberlerAdapter? = null
    private lateinit var haberlist: List<Haberler>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            ApiCallWithUrl("http://newsapi.org/v2/top-headlines?country=tr&apiKey=9dc708da3dec4b1b8ef623eba766e145")



           Handler().postDelayed({
                adapter = HaberlerAdapter(this, haberlist as ArrayList<Haberler>)
                gvNews.adapter = adapter;
            }, 2000)

        }

        fun ApiCallWithUrl(url: String){
            val req = Request.Builder().url(url).build()

            client.newCall(req).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    println("Error  : ${e.message}")
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseStr = response.body?.string()
                    val data = JSONObject(responseStr)
                    haberlist = Gson().fromJson(data.getString("articles"), Array<Haberler>::class.java).toList()
                }
            })
        }
    }