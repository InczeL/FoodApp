

package com.example.wheretoeat.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.wheretoeat.R
import com.example.wheretoeat.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_start, container, false)
    }



}