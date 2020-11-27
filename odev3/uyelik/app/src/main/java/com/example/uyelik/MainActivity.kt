package com.example.uyelik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var isim = findViewById(R.id.isim) as TextView
        var soyisim = findViewById(R.id.soyisim) as TextView
        var yas = findViewById(R.id.yas) as TextView
        var eposta = findViewById(R.id.eposta) as TextView
        var sifre = findViewById(R.id.sifre) as TextView
        var sifret = findViewById(R.id.sifret) as TextView
        var girisa = findViewById(R.id.giris) as Button
        var isimg = findViewById(R.id.isimg) as EditText
        var soyisimg = findViewById(R.id.soyisimgi) as EditText
        var yasg = findViewById(R.id.yasg) as EditText
        var epostag = findViewById(R.id.epostag) as EditText
        var sifreg = findViewById(R.id.sifreg) as EditText
        var sifretg = findViewById(R.id.sifretg) as EditText


        fun namesControl(value: String): Boolean {
            return Regex("[a-zA-ZğĞİıöÖşŞüÜ]{2,}").containsMatchIn(value)
        }

        giris.setOnClickListener(){

            if (!namesControl(isimg.text.toString())){
                Toast.makeText(applicationContext, "İsim bilgisini eksik veya yanlış girdiniz!", Toast.LENGTH_LONG).show()
            }
            else if(!namesControl(soyisimg.text.toString())){
                Toast.makeText(applicationContext, "Soyisim bilgisini eksik veya yanlış girdiniz!", Toast.LENGTH_LONG).show()
            }
            else if(yasg.text.isEmpty() || yasg.text.toString().toInt() !in 18..100){
                Toast.makeText(applicationContext, "Yaş bilgisini  yanlış girdiniz!", Toast.LENGTH_LONG).show()
            }
            else if(!Regex("[a-zA-Z]{2,}@[a-zA-Z]{2,}").containsMatchIn(epostag.text.toString())){
                Toast.makeText(applicationContext, "E-posta formatı hatalıdır!!", Toast.LENGTH_LONG).show()
            }
            else if(sifreg.text.toString().trim().length < 5 ){
                Toast.makeText(applicationContext, "Şifre en az 5 karakterden oluşmalıdır!", Toast.LENGTH_LONG).show()
            }
            else if (sifreg.text.toString() != sifretg.text.toString()){
                Toast.makeText(applicationContext, "Girilen şifreler uyuşmuyor!", Toast.LENGTH_LONG).show()
            }
            else
                Toast.makeText(applicationContext, "Kayıt oluşturulmuştur!", Toast.LENGTH_LONG).show()

        }

    }
}