package com.yogisn.foods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail_foods.*

class MainActivity : AppCompatActivity(){

    private lateinit var rvFoods: RecyclerView
    private var list: ArrayList<Foods> = arrayListOf()
//    private lateinit var listFoodsAdapter:ListFoodsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        list.addAll(FoodsData.lisData)
        showRecycleList()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        menuMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun showRecycleList() {
        rvFoods.layoutManager = LinearLayoutManager(this)
        val listFoodsAdapter = ListFoodsAdapter(list)
        rvFoods.adapter = listFoodsAdapter

        listFoodsAdapter.setOnItemClickCallback(object : ListFoodsAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Foods) {
                // showSelectedFoods(data)
                val intent = Intent(this@MainActivity, DetailFoods::class.java)
                    .apply {
                        putExtra(DetailFoods.IMG_FOOD, data.gambar)
                        putExtra(DetailFoods.NAME_FOOD, data.name)
                        putExtra(DetailFoods.DETAIL_FOOD, data.detail)
                    }
                startActivity(intent)
            }
        })
    }

//    private fun showSelectedFoods(foods: Foods) {
//        Toast.makeText(this, "Your choice : " + foods.name, Toast.LENGTH_SHORT).show()
//    }

    private fun menuMode(selectedMode: Int) {
        when(selectedMode){
            R.id.about->{
                val aboutIntent = Intent(this, About::class.java)
                startActivity(aboutIntent)
            }

        }
    }
}