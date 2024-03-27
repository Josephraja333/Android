package com.example.takenotes

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.takenotes.databinding.FragmentNotesBinding

class Notes : Fragment() {
    private lateinit var binding: FragmentNotesBinding
    private lateinit var viewModel: WritingViewModel
    private lateinit var viewModel2: NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[WritingViewModel::class.java]
        viewModel2 = ViewModelProvider(this)[NotesViewModel::class.java]
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.i("NotesFragment","iam inevitable")
    }

    override fun onResume() {
        super.onResume()
        val arr = viewModel2.arraylist.value?.size
        if(arr != null) {
            Log.i("NotesFragment", viewModel2.arraylist.value?.[0].toString())
            addNewTextView()
        }
        Log.i("NotesFragment","work")
    }
    private fun addNewTextView() {
        val linearLayout = binding.linearLayout
        for(i in 0..(viewModel2.arraylist.value?.size?.minus(1) ?: 0)) {
            Log.i("NotesFragment",i.toString())
            val newTextView = TextView(requireContext())
            newTextView.text = viewModel2.arraylist.value[i]
            newTextView.textSize = 30F
            newTextView.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            newTextView.setBackgroundResource(R.drawable.border)
            newTextView.id = View.generateViewId()
            newTextView.setOnClickListener {
                handleTextViewClick(newTextView)
            }
            linearLayout.addView(newTextView)
        }

    }

    private fun handleTextViewClick(textView: TextView) {
        val message = textView.text.toString()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.writingBtn.setOnClickListener {

            findNavController().navigate(R.id.action_notes_to_writing)

        }
    }





}
