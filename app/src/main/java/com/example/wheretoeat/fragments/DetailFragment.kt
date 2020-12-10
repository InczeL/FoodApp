package com.example.wheretoeat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.wheretoeat.R
import com.example.wheretoeat.databinding.FragmentDetailBinding


class DetailFragment (): Fragment() {
    private lateinit var binding : FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        binding.name.text=arguments?.getString("name")
        binding.address.text=arguments?.getString("address")
        binding.city.text=arguments?.getString("city")
        binding.state.text=arguments?.getString("state")
        binding.area.text=arguments?.getString("area")
        binding.postalCode.text=arguments?.getString("postal_code")
        binding.country.text=arguments?.getString("country")
        binding.phone.text=arguments?.getString("phone")
        return binding.root

    }
}