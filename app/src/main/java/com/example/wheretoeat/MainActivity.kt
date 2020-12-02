package com.example.wheretoeat

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.PrimaryKey
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModelDB
import com.example.wheretoeat.ViewModels.RestaurantViewModelFactory
import com.example.wheretoeat.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RestaurantViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val repository = Repository()
        val viewModelFactory = RestaurantViewModelFactory(repository)
        var restaurantViewModelDB:RestaurantViewModelDB =ViewModelProvider(this).get(RestaurantViewModelDB::class.java)
        viewModel= ViewModelProvider(this,viewModelFactory).get(RestaurantViewModel::class.java)
        viewModel.getCoutries()
        viewModel.myResponseCountri.observe(this,{response->
            for(i in response.body()?.countries!!){
                viewModel.getRestaurantsByCountry(i)
            }
        })
        viewModel.myResponse.observe(this,{response->
            for(i in response.body()?.restaurants!!){
                restaurantViewModelDB.addRestaurant(i)
            }
        })
    }


}