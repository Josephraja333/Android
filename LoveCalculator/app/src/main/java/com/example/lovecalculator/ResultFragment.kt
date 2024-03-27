package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentResultBinding
import java.util.Random

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)

        binding.tv4.setText(arguments?.getString("last")+" & "+arguments?.getString("first"))

        var c = (0..100).random()

        binding.tv5.setText(c.toString()+"%")
        binding.tv6.setText(slog(c))

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
        return binding.root
    }

    fun slog(c : Int) : String{
        if (c < 11) {
            return "Doomed to heartbreak";
        } else if (c < 21) {
            return "Better off as friends";
        } else if (c < 31) {
            return "Potential, but uncertain";
        } else if (c < 41) {
            return "Some sparks, give it time";
        } else if (c < 51) {
            return "Growing affection";
        } else if (c < 61) {
            return "Falling in love";
        } else if (c < 71) {
            return "Deeply in love";
        } else if (c < 81) {
            return "Head over heels";
        } else if (c < 91) {
            return "Soulmates";
        }
        return "Infinite love, forever together";


    }
}