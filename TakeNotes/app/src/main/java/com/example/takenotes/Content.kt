package com.example.takenotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.takenotes.databinding.FragmentContentBinding

class Content : Fragment() {

    private lateinit var binding: FragmentContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {
        super.onCreate(savedInstanceState)
        binding = FragmentContentBinding.inflate(layoutInflater)

        binding.writingBtn.setOnClickListener {
            findNavController().navigate(R.id.action_content2_to_notes)
        }
        return binding.root
    }



}
