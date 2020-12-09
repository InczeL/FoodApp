

package com.example.wheretoeat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.wheretoeat.R
import com.example.wheretoeat.ViewModels.RestaurantViewModelDB
import com.example.wheretoeat.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    private lateinit var binding: FragmentStartBinding
    private val  dbViewModel: RestaurantViewModelDB by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_start,container,false)

        binding.singInBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                v?.findNavController()?.navigate(R.id.action_startFragment_to_singInFragment,savedInstanceState)
            }

        })
        binding.loginBtn.setOnClickListener{
                if(binding.userName.text.isEmpty() || binding.password.text.isEmpty()){
                    Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
                }
                else{
                    val user = dbViewModel.getUser(binding.userName.text.toString())
                    if(user.password == binding.password.text.toString()){
                        it?.findNavController()?.navigate(R.id.action_startFragment_to_mainActivity,savedInstanceState)
                    }
                    else{
                        Toast.makeText(requireContext(),"Wrong password",Toast.LENGTH_LONG).show()
                    }
                }
        }

        return binding.root
    }



}