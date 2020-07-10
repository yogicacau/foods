package com.yogisn.foods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class ListFoodsAdapter (val listFoods: ArrayList<Foods>) : RecyclerView.Adapter<ListFoodsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Foods)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_foods, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val foods = listFoods[position]

        Glide.with(holder.itemView.context)
            .load(foods.gambar)
            .apply(RequestOptions().override(100,100))
            .into(holder.imgPhoto)

        holder.tvName.text = foods.name
        holder.tvDetails.text = foods.detail


        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFoods[holder.adapterPosition])
        }

    }

    override fun getItemCount(): Int {
        return listFoods.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetails: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}