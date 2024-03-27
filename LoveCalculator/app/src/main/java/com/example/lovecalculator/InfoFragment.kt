package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentInfoBinding

class InfoFragment : Fragment() {
   private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        binding.button2.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("first",binding.t1.text.toString())
            bundle.putString("last",binding.t2.text.toString())

            findNavController().navigate(R.id.action_infoFragment_to_resultFragment,bundle)
        }
        return binding.root
    }


}