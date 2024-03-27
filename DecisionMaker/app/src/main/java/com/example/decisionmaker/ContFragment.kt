package com.example.decisionmaker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.decisionmaker.databinding.FragmentContBinding


class ContFragment : Fragment() {
    private lateinit var binding: FragmentContBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentContBinding.inflate(layoutInflater)
        binding.button2.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("key",binding.t1.text.toString())
            findNavController().navigate(R.id.action_contFragment_to_resultFragment,bundle)
        }

        return binding.root
    }


}