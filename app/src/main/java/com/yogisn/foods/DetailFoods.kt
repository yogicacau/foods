package com.yogisn.foods

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.activity_detail_foods.*

class DetailFoods : AppCompatActivity() {

    companion object {
        const val NAME_FOOD = "name_food"
        const val DETAIL_FOOD = "detail_food"
        const val IMG_FOOD = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_foods)

        showDetailFoods()
    }

    private fun showDetailFoods() {
        tv_name_food.setText(intent.getStringExtra(NAME_FOOD))
        tv_detail.setText(intent.getStringExtra(DETAIL_FOOD))

        val imgDetail: ImageView = findViewById(R.id.img_detail)
//        println("Image Detail :" + imgDetail)
        Glide.with(this)
             .load(intent.getIntExtra(IMG_FOOD,0))
             .skipMemoryCache(true)
             .diskCacheStrategy(DiskCacheStrategy.NONE)
             .placeholder(R.drawable.ic_launcher_foreground)
             .error(R.drawable.ic_launcher_foreground)
             .into(imgDetail)
    }
}
