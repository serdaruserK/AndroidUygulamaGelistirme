package com.example.sehirlergrid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter: SehirAdapter?=null
    var sehirlist = ArrayList<Sehirler>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sehirlist.add(Sehirler("Coffee", R.drawable.coffee_pot))
        sehirlist.add(Sehirler("Espersso", R.drawable.espresso))
        sehirlist.add(Sehirler("French Fires", R.drawable.french_fries))
        sehirlist.add(Sehirler("Honey",R.drawable.honey))
        sehirlist.add(Sehirler("Strawberry", R.drawable.strawberry_ice_cream))
        sehirlist.add(Sehirler("Sugar cubes", R.drawable.sugar_cubes))
        adapter = Sehirler(this, sehirlist)

        gvSehir.adapter = adapter
    }

    class FoodAdapter : BaseAdapter {
        var sehirlist = ArrayList<Sehirler>()
        var context: Context? = null

        constructor(context: Context, sehirList : ArrayList<Sehirler>) : super() {
            this.context = context
            this.sehirlist = sehirList
        }

        override fun getCount(): Int {
            return sehirlist.size
        }

        override fun getItem(position: Int): Any {
            return sehirlist[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = this.sehirlist[position]

            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView = inflator.inflate(R.layout.food_entry, null)
            foodView.imgFood.setImageResource(food.image!!)
            foodView.tvName.text = food.name!!

            return foodView
        }
    }
    }
}