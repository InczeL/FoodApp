package com.example.wheretoeat.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.model.Restaurant
import kotlinx.android.synthetic.main.restaurant.view.*

class RestaurantAdapter(private val List: List<Restaurant>):RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.restaurant,parent,false)
        return  RestaurantViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val currentItem= List.get(position)
        holder.m_title.text=currentItem?.name
        holder.m_address.text=currentItem?.address
        holder.m_price.text=currentItem?.price.toString()
    }
    override fun getItemCount()= List.size

    class RestaurantViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val m_title :TextView=itemView.title
        val m_address:TextView=itemView.address
        val m_price:TextView=itemView.price
    }
}