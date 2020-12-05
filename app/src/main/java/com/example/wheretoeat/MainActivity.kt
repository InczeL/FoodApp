package com.example.wheretoeat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModelFactory
import com.example.wheretoeat.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RestaurantViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = RestaurantViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(RestaurantViewModel::class.java)
        //viewModel.getCoutries()
        /*viewModel.myResponseCountri.observe(this,{response->
            for(i in response.body()?.countries!!){
                viewModel.getRestaurantsByCountry(i)
            }
        })*/
    }


}