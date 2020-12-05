package com.example.wheretoeat.ui.restaurantList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.databinding.FragmentRestaurantlistBinding
import com.example.wheretoeat.util.RestaurantAdapter
import java.util.*
import java.util.Objects as objects

class RestaurantList : Fragment() {
    private  lateinit var  binding :FragmentRestaurantlistBinding
    private  val restaurantViewModel:RestaurantViewModel by activityViewModels()
    private  var  page:Int =1
    var country :String ="US"
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_restaurantlist,container,false)
        restaurantViewModel.getCoutries();
        restaurantViewModel.myResponseCountri.observe(viewLifecycleOwner,{response->
            if(response.isSuccessful){
                val countries:List<String> = restaurantViewModel.myResponseCountri.value!!.body()!!.countries
                val adapter =ArrayAdapter<String>(requireActivity().baseContext,android.R.layout.simple_dropdown_item_1line,countries)
                adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                binding.countrySpinner.adapter =adapter
                country=binding.countrySpinner.selectedItem.toString()
            }
        })
        Log.d("Test" ,country)
        restaurantViewModel.getRestaurantsByCountry(country,page)
        restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
            if(response.isSuccessful){
                binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                binding.recyclerView.setHasFixedSize(true)
                if(page+1*response!!.body()!!.per_page>response!!.body()!!.total_entries){
                    binding.nextbtn.visibility = View.GONE
                }
                if(page ==1){
                    binding.prevbtn.visibility= View.GONE
                }
                else{
                    binding.prevbtn.visibility = View.VISIBLE
                }
            }
        })

        binding.nextbtn.setOnClickListener{
            page++
            restaurantViewModel.getRestaurantsByCountry(country,page)
            restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
                if(response.isSuccessful){
                    binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                    binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                    binding.recyclerView.setHasFixedSize(true)
                }
            })
        }
        binding.prevbtn.setOnClickListener{
            page--
            restaurantViewModel.getRestaurantsByCountry(country,page)
            restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
                if(response.isSuccessful){
                    binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                    binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                    binding.recyclerView.setHasFixedSize(true)
                }
            })
        }



        return  binding.root
    }
}