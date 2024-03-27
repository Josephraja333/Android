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
import com.example.roomdata.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val application = requireNotNull(this.activity).application
        val dataSource = FormDatabase.getInstance(application).formDatabaseDAO
        val viewModelFactory = FormViewModelFactory(dataSource,application)
        viewModel = ViewModelProvider(requireActivity(),viewModelFactory)[FormViewModel::class.java]
        binding.button2.setOnClickListener {
            viewModel.insertData(binding.editTextText.text.toString(),binding.editTextText2.text.toString(),binding.editTextText3.text.toString(),binding.editTextText4.text.toString())
            viewModel.getDetails()
            findNavController().navigate(R.id.action_homeFragment_to_resultFragment)
        }
        return binding.root
    }

}