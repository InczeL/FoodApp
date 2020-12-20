@file:Suppress("DEPRECATION")

package com.example.wheretoeat.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock.sleep
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.ViewModels.ProfileViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.databinding.FragmentRestaurantlistBinding
import com.example.wheretoeat.util.RestaurantAdapter

class RestaurantListFragment : Fragment() {
    private  lateinit var  binding :FragmentRestaurantlistBinding
    private  val restaurantViewModel:RestaurantViewModel by activityViewModels()
    private val  profileViewModel: ProfileViewModel by activityViewModels()
    private  var  page:Int =1
    private  var positon: Int =0
    var  city :String="Addison"
    private lateinit var  adapterView :RestaurantAdapter
    var arrayOfRestaurants : ArrayList<Restaurant> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null){
            city = savedInstanceState.getString("LastCity").toString()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_restaurantlist,container,false)
        restaurantViewModel.getCities()
        restaurantViewModel.myResponseCities.observe(viewLifecycleOwner,{ response->
            if(response.isSuccessful){
                val cities:List<String> = restaurantViewModel.myResponseCities.value!!.body()!!.cities
                binding.spinner.adapter=ArrayAdapter<String>(requireActivity().baseContext,android.R.layout.simple_spinner_item,cities)
                var positon :Int = cities.indexOf(city)
                binding.spinner.setSelection(positon)
                binding.spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        city=cities[position]
                        page=1
                        arrayOfRestaurants.clear()
                        restaurantViewModel.getRestaurantsByCity(city,page)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                }
            }

        })
        restaurantViewModel.getRestaurantsByCity(city,page)
        restaurantViewModel.myResponseCity.observe(viewLifecycleOwner,{response->
            if(response.isSuccessful){
                if(response.body()!!.restaurants.size>0){
                arrayOfRestaurants.addAll(response.body()!!.restaurants)

                adapterView =RestaurantAdapter(arrayOfRestaurants,profileViewModel)
                binding.recyclerView.adapter= adapterView
                binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                binding.recyclerView.setHasFixedSize(true)
                if(binding.recyclerView.layoutManager!!.itemCount > response!!.body()!!.per_page) {
                    binding.recyclerView.scrollToPosition(binding.recyclerView.layoutManager!!.itemCount - response!!.body()!!.per_page)
                }
                }
                else{
                    Toast.makeText(activity,"Data not found",Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Log.d("Test",response.toString())
            }
        })
        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                positon =adapterView.getPosition()
                if(binding.recyclerView.layoutManager!!.itemCount == positon + 1 ){
                    page++
                    restaurantViewModel.getRestaurants(page)
                   sleep(100)
                }
            }
        })

        return  binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("LastCity",city)
        super.onSaveInstanceState(outState)

    }
}
