package com.example.wheretoeat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.wheretoeat.ViewModels.ProfileViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModel
import com.example.wheretoeat.ViewModels.RestaurantViewModelFactory
import com.example.wheretoeat.databinding.ActivityMainBinding
import com.example.wheretoeat.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RestaurantViewModel
    private  lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView( this,R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = RestaurantViewModelFactory(repository)
        val profileViewModel :ProfileViewModel by viewModels()
        viewModel = ViewModelProvider(this,viewModelFactory).get(RestaurantViewModel::class.java)

        setUpNavigation()

    }
    fun setUpNavigation(){
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
        NavigationUI.setupWithNavController(
            binding.navView,
            navHostFragment!!.navController
        )
    }

}