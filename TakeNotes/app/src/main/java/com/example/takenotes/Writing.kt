package com.example.takenotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.takenotes.databinding.FragmentNotesBinding
import com.example.takenotes.databinding.FragmentWritingBinding

class Writing : Fragment() {
    private lateinit var binding: FragmentWritingBinding
    private lateinit var viewModel: WritingViewModel
    private lateinit var viewModel2: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentWritingBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[WritingViewModel::class.java]


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentWritingBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[WritingViewModel::class.java]
        viewModel2 = ViewModelProvider(this)[NotesViewModel::class.java]
        binding.writingBtn.setOnClickListener {
            viewModel.bundle=bundleWriting()
            viewModel2.arraylist.add(viewModel.bundle?.getString(viewModel.counter.toString()))
            findNavController().navigate(R.id.writing_to_notes_fragment)
        }
        return binding.root
    }


    fun bundleWriting():Bundle{
        return Bundle().apply {
            putString(viewModel.counter++.toString(),binding.nt.text.toString())
        }
    }


}