package com.example.wheretoeat.ui.restaurantList

import android.os.Bundle
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
import com.example.wheretoeat.R
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.databinding.FragmentRestaurantlistBinding
import com.example.wheretoeat.util.RestaurantAdapter

class RestaurantList : Fragment() {
    private  lateinit var  binding :FragmentRestaurantlistBinding
    private  val restaurantViewModel:RestaurantViewModel by activityViewModels()
    private  var  page:Int =1
    private  var country :String ="US"
    private  var city:String=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_restaurantlist,container,false)
        restaurantViewModel.getCoutries();
        restaurantViewModel.myResponseCountry.observe(viewLifecycleOwner,{ response->
            if(response.isSuccessful){
                val countries:List<String> = restaurantViewModel.myResponseCountry.value!!.body()!!.countries
                binding.countrySpinner.adapter =ArrayAdapter<String>(requireActivity().baseContext,android.R.layout.simple_spinner_item,countries)
                binding.countrySpinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        country=countries[position]
                        page=1
                        restaurantViewModel.getRestaurantsByCountry(country,page)
                    }

                    override fun onNothingSelected(parent: AdapterView<*>?) {
                        TODO("Not yet implemented")
                    }

                }
            }
        })
        restaurantViewModel.getRestaurantsByCountry(country,page)
        restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
            if(response.isSuccessful){
                binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                binding.recyclerView.setHasFixedSize(true)
                if(page*response!!.body()!!.per_page < response!!.body()!!.total_entries){
                    binding.nextbtn.visibility = View.VISIBLE
                }
                else{
                    binding.nextbtn.visibility=View.GONE
                }
                if(page ==1){
                    binding.prevbtn.visibility= View.GONE
                }
                else{
                    binding.prevbtn.visibility = View.VISIBLE
                }
            }
        })
        binding.searchbtn.setOnClickListener{
            if(binding.editTextCity.text.isEmpty()){
                Toast.makeText(activity?.baseContext,"Please entry a city name",Toast.LENGTH_SHORT).show()
            }
            else{
                page=1
                city=binding.editTextCity.text.toString()
                binding.editTextCity.text.clear()
                restaurantViewModel.getRestaurantsByCity(city,page)
                restaurantViewModel.myResponseCity.observe(viewLifecycleOwner,{response->
                    if(response.isSuccessful)
                        binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                        binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                        binding.recyclerView.setHasFixedSize(true)
                        if(page*response!!.body()!!.per_page < response!!.body()!!.total_entries){
                            binding.nextbtn.visibility = View.VISIBLE
                        }
                        else{
                            binding.nextbtn.visibility=View.GONE
                        }
                        if(page ==1){
                            binding.prevbtn.visibility= View.GONE
                        }
                        else{
                            binding.prevbtn.visibility = View.VISIBLE
                        }
                })
            }
        }
        binding.nextbtn.setOnClickListener{
            page++
            Log.d("TestN",city)
            if(city.isEmpty()){
                restaurantViewModel.getRestaurantsByCountry(country,page)
                restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
                    if(response.isSuccessful){
                        binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                        binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                        binding.recyclerView.setHasFixedSize(true)
                    }
                })
            }
            else{
                restaurantViewModel.getRestaurantsByCity(city,page)
                restaurantViewModel.myResponseCity.observe(viewLifecycleOwner,{response->
                    if(response.isSuccessful){
                        binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                        binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                        binding.recyclerView.setHasFixedSize(true)
                    }
                })
            }

        }
        binding.prevbtn.setOnClickListener{
            page--
            Log.d("TestP",city)
            if(city.isEmpty()) {
                restaurantViewModel.getRestaurantsByCountry(country, page)
                restaurantViewModel.myResponse.observe(viewLifecycleOwner,{response->
                    if(response.isSuccessful){
                        binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                        binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                        binding.recyclerView.setHasFixedSize(true)
                    }
                })
            }
            else{
                restaurantViewModel.getRestaurantsByCity(city,page)
                restaurantViewModel.myResponseCity.observe(viewLifecycleOwner,{response->
                    if(response.isSuccessful){
                        binding.recyclerView.adapter= RestaurantAdapter(response.body()!!.restaurants)
                        binding.recyclerView.layoutManager=LinearLayoutManager(activity?.baseContext)
                        binding.recyclerView.setHasFixedSize(true)
                    }
                })
            }

        }


        return  binding.root
    }
}