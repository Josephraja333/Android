package com.example.navlib1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navlib1.databinding.FragmentTwoBinding


class fragment_two : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTwoBinding.inflate(inflater,container,false)
        binding.text2.setOnClickListener {
           findNavController().navigate(R.id.tofragmentone)
        }
        return binding.root
    }


}