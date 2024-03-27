package com.example.randomuser.Fragments

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.content.Intent
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import com.example.randomuser.Database.RandomDatabase
import com.example.randomuser.Database.ViewModels.RandomDataViewModel
import com.example.randomuser.Database.ViewModels.RandomViewModelFactory
import com.example.randomuser.Models.RandomViewModel
import com.example.randomuser.Models.RecyclerViewAdapter
import com.example.randomuser.WeatherApi.RetrofitInstance
import com.example.randomuser.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.util.logging.Handler


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var recyclerAdapter : RecyclerViewAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: RandomViewModel
    private lateinit var dViewModel: RandomDataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(requireActivity())[RandomViewModel::class.java]
        val application = requireNotNull(this.activity).application
        val dataSource = RandomDatabase.getInstance(application).formDatabaseDAO
        val viewModelFactory = RandomViewModelFactory(dataSource,application)
        dViewModel = ViewModelProvider(requireActivity(),viewModelFactory)[RandomDataViewModel::class.java]

        if(viewModel.displayUser.size==0){
            lifecycleScope.launch{
                viewModel.addToList(dViewModel)
                initializeRecyclerView()
            }
        }
        else initializeRecyclerView()
        setWeather()

        return binding.root
    }

    private fun initializeRecyclerView(){
        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        recyclerView = binding.rv
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recyclerAdapter = RecyclerViewAdapter(viewModel.displayUser,width)
        recyclerView.adapter = recyclerAdapter

        binding.sv.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val a = viewModel.filterList(newText)
                recyclerAdapter.setFilteredList(a)
                return true
            }
        })

        recyclerAdapter.notifyDataSetChanged()
    }

    private fun setWeather(){
        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.getWeather("chennai")
            }
            catch (e: IOException) {
                println("Internet error: ${e.message}")
                return@launch
            }
            catch (e: HttpException) {
                println("Unexpected response: ${e.message}")
                return@launch
            }

            if(response.isSuccessful && response.body() != null) {
                val a = response.body()
                val c = a?.data?.cel.toString()
                val d = a?.data?.condition?.text.toString()
                val e = a?.data?.condition?.icon

                binding.tv2.text = c + "°  Chennai\n" + d
                binding.image.load("https://"+e?.removeRange(0,2))
            } else {
                println("Response not successful")
            }
        }
    }
}