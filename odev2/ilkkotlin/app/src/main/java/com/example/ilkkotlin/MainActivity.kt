package com.example.ilkkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mybutton = findViewById<Button>(R.id.mybutton)

        mybutton.setOnClickListener {
            Toast.makeText(this, "Beni tanıdıysanız ne mutlu ! :) Teşekkürler..", Toast.LENGTH_SHORT).show()
        }
    }
}