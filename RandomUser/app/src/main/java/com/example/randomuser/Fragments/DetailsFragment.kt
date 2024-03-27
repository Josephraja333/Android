package com.example.randomuser.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.randomuser.R
import com.example.randomuser.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(layoutInflater)
        binding.prof.load(arguments?.getString("imageUrl"))
        binding.name.text  = "Name: "+arguments?.getString("name")
        binding.email.text = "Email: "+arguments?.getString("email")
        binding.country.text = "Country: "+arguments?.getString("country")
        binding.phone.text = "Phone: "+arguments?.getString("phone")
        binding.dob.text = "DOB: "+arguments?.getString("dob")?.removeRange(10,24)
        val a = listOf(R.drawable.blob,R.drawable.circle,R.drawable.layer,R.drawable.polygon,R.drawable.sctter)
        binding.back.setBackgroundResource(a.random())

        binding.weather.setOnClickListener {
            val bundle = Bundle()
            print(arguments?.getString("country"))
            bundle.putString("country",arguments?.getString("country"))

            findNavController().navigate(R.id.action_detailsFragment_to_weatherFragment,bundle)
        }
        return binding.root
    }


}