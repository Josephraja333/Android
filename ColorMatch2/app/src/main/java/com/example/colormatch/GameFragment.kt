package com.example.colormatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.colormatch.databinding.FragmentGameBinding


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        chk()
        return binding.root
    }

    private fun chk(){
        val a = (0..2).random()

        when(a){
            0 -> binding.disp.setBackgroundResource(R.color.blue)
            1 -> binding.disp.setBackgroundResource(R.color.pink)
            2 -> binding.disp.setBackgroundResource(R.color.green)
        }
        val colors = mutableListOf(R.color.blue, R.color.pink, R.color.green)
        colors.shuffle()

        binding.first.setBackgroundResource(colors[0])
        binding.second.setBackgroundResource(colors[1])
        binding.third.setBackgroundResource(colors[2])
        binding.first.setOnClickListener {
            if (binding.first.background.constantState?.equals(binding.disp.background.constantState) == true) {
                counter++
                chk()
            } else {
                val bundle = Bundle()
                bundle.putInt("score", counter)
                findNavController().navigate(R.id.action_gameFragment_to_lostFragment, bundle)
            }
        }

        binding.second.setOnClickListener {
            if (binding.second.background.constantState?.equals(binding.disp.background.constantState) == true) {
                counter++
                chk()
            } else {
                val bundle = Bundle()
                bundle.putInt("score", counter)
                findNavController().navigate(R.id.action_gameFragment_to_lostFragment, bundle)
            }
        }

        binding.third.setOnClickListener {
            if (binding.third.background.constantState?.equals(binding.disp.background.constantState) == true) {
                counter++
                chk()
            } else {
                val bundle = Bundle()
                bundle.putInt("score", counter)
                findNavController().navigate(R.id.action_gameFragment_to_lostFragment, bundle)
            }
        }
    }
}