package com.example.wheretoeat.fragments

import android.os.Bundle
import android.text.TextUtils
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
import com.example.wheretoeat.databinding.FragmentSingInBinding
import com.example.wheretoeat.model.RestaurantDao
import com.example.wheretoeat.model.RestaurantDatabase
import com.example.wheretoeat.model.User


class SingInFragment : Fragment() {

    private  lateinit var binding :FragmentSingInBinding
    private val  dbViewModel: RestaurantViewModelDB by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_sing_in,container,false)
        binding.siSingInBtn.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                if(binding.siPassword.text.toString() != binding.siConfPassword.text.toString()){
                    Toast.makeText( requireContext(),"Wrong Password",Toast.LENGTH_SHORT).show()
                    binding.siConfPassword.text.clear()
                }
                else{
                    insertData()
                    v?.findNavController()?.navigate(R.id.action_singInFragment_to_startFragment,savedInstanceState)
                }

            }

        })
        return binding.root
    }
    fun insertData(){
        val name = binding.siUserName.text.toString()
        val password = binding.siPassword.text.toString()
        val address = binding.siAddress.text.toString()
        val phone_number = binding.siPhone.text.toString()
        val email = binding.siEmail.text.toString()
        if(imputCheck(name,password,address,phone_number,email)){
            val user = User(name,password,address,phone_number,email)
            dbViewModel.addUser(user)
            Toast.makeText(requireContext(),"Success",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(requireContext(),"Please fill out all fields",Toast.LENGTH_LONG).show()
        }
    }
    fun imputCheck( name : String, passwor : String, address : String, phone_number : String, email : String):Boolean{

        return !(TextUtils.isEmpty(name) &&
                 TextUtils.isEmpty(passwor)&&
                 TextUtils.isEmpty(address)&&
                 TextUtils.isEmpty(phone_number)&&
                 TextUtils.isEmpty(phone_number)&&
                 TextUtils.isEmpty(email))
    }
}