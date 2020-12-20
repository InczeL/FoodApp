package com.example.wheretoeat.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wheretoeat.R
import com.example.wheretoeat.ViewModels.ProfileViewModel
import com.example.wheretoeat.database.Restaurant
import com.example.wheretoeat.databinding.FragmentProfileBinding
import com.example.wheretoeat.util.RestaurantAdapter


class ProfileFragment : Fragment() {
    private lateinit var binding :FragmentProfileBinding
    private val  profileViewModel: ProfileViewModel by activityViewModels()
    private  var arrayOfFavorites : ArrayList<Restaurant> = arrayListOf()
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false)

        binding.pName.text=profileViewModel.user.name
        binding.pPhone.text=profileViewModel.user.phone_number
        binding.pAddress.text=profileViewModel.user.address
        binding.pMail.text=profileViewModel.user.email
        arrayOfFavorites.addAll(profileViewModel.getFavorits())
        binding.pRecyclerView.adapter = RestaurantAdapter(arrayOfFavorites,profileViewModel)
        binding.pRecyclerView.layoutManager= LinearLayoutManager(activity?.baseContext)
        binding.pRecyclerView.setHasFixedSize(true)
        return binding.root
    }
}