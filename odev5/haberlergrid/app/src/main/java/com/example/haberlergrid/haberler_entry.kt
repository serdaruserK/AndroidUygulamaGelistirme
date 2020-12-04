package com.example.haberlergrid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_haberler_entry.*


class haberler_entry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_haberler_entry)

        var bundle = intent.extras


        textTitle.text = bundle?.getString("title")
        textDes.text = bundle?.getString("description")
        txtUrl.text = bundle?.getString("author")
        Picasso.get().load(bundle?.getString("image")).into(findViewById<ImageView>(R.id.imageView));

    }
}