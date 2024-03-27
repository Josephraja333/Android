package com.example.navlib1
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navlib1.databinding.FragmentOneBinding

class fragment_one : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOneBinding.inflate(inflater, container, false)
        binding.text.setOnClickListener {
            findNavController().navigate(R.id.tofragmenttwo)
        }
        return binding.root
    }
}
