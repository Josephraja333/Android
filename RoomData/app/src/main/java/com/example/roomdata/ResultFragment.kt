package com.example.roomdata

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdata.Database.FormDatabase
import com.example.roomdata.Database.ViewModels.FormViewModel
import com.example.roomdata.Database.ViewModels.FormViewModelFactory
import com.example.roomdata.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater)
        val application = requireNotNull(this.activity).application
        val dataSource = FormDatabase.getInstance(application).formDatabaseDAO
        val viewModelFactory = FormViewModelFactory(dataSource,application)
        viewModel = ViewModelProvider(requireActivity(),viewModelFactory).get(FormViewModel::class.java)

        binding.button.setOnClickListener {
            viewModel.clearData()
            findNavController().navigate(R.id.action_resultFragment_to_homeFragment)
        }
        binding.textView.text = viewModel.finalOut.value
        return binding.root
    }



}