package com.example.wheretoeat.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.fragments.DetailFragment
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
        holder.itemView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {

                val bundle = bundleOf(
                    "id" to currentItem.id,
                    "name" to currentItem.name,
                    "address" to currentItem.address,
                    "city" to currentItem.city,
                    "state" to currentItem.state,
                    "area" to currentItem.area,
                    "postal_code" to currentItem.postal_code,
                    "country" to currentItem.country,
                    "price" to currentItem.price,
                    "lat" to currentItem.lat,
                    "lng" to currentItem.lng,
                    "phone" to currentItem.phone,
                    "reserve_url" to currentItem.reserve_url,
                    "mobile_reserve_url" to currentItem.mobile_reserve_url,
                    "image_url" to currentItem.image_url

                )
                v?.findNavController()?.navigate(R.id.action_restaurant_list_to_detailFragment,bundle)


            }

        })
    }
    override fun getItemCount()= List.size

    class RestaurantViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        val m_title :TextView=itemView.title
        val m_address:TextView=itemView.address
        val m_price:TextView=itemView.price
    }
}