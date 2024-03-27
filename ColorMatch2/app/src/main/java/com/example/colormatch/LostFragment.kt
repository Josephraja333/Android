package com.example.colormatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.colormatch.databinding.FragmentLostBinding

class LostFragment : Fragment() {
    private lateinit var binding: FragmentLostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLostBinding.inflate(layoutInflater)

        val score = arguments?.getInt("score", 0)

        binding.tv6.text = "Your Score: $score"

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_lostFragment_to_gameFragment)
        }
        return binding.root
    }

}