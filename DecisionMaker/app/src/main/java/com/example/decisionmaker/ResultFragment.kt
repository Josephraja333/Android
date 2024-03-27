package com.example.decisionmaker

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.decisionmaker.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        var a = arguments?.getString("key")?.split(" ")
        var b = (0..a!!.size-1).random()
        binding.tv6.setText("Do " + a[b])

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
        return binding.root
    }


}