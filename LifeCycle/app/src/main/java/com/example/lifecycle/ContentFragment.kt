package com.example.lifecycle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.lifecycle.databinding.FragmentContentBinding


class ContentFragment : Fragment() {
    private lateinit var binding: FragmentContentBinding
    private lateinit var view : ContentViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContentBinding.inflate(layoutInflater)
        view = ViewModelProvider(requireActivity())[ContentViewModel::class.java]
        binding.textView.text = view.value.toString()
        binding.button3.setOnClickListener {
            view.value--
            binding.textView.text = view.value.toString()
        }
        binding.button2.setOnClickListener {
            view.value++
            binding.textView.text = view.value.toString()
        }
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_contentFragment_to_changeFragment)
        }
        return binding.root
    }


}