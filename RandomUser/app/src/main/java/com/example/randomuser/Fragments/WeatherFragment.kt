package com.example.randomuser.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.randomuser.WeatherApi.RetrofitInstance
import com.example.randomuser.databinding.FragmentWeatherBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class WeatherFragment : Fragment() {
    private lateinit var binding: FragmentWeatherBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)

        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.api.getWeather(arguments?.getString("country")!!)

                if (response.isSuccessful && response.body() != null) {
                    val a = response.body()
                    println(a)
                    binding.imageView.load("https://" + a?.data?.condition?.icon?.removeRange(0, 2))
                    binding.country.text = "Country: " + arguments?.getString("country")!!
                    binding.weatherText.text = "Weather: " + a?.data?.condition?.text
                    binding.celcius.text = "Celsius: " + a?.data?.cel.toString() + "°"
                    binding.aq.text = "Air Quality is " + when (a?.data?.aq?.index) {
                        1 -> "Good"
                        2 -> "Moderate"
                        3 -> "Unhealthy for sensitive people"
                        4 -> "Unhealthy"
                        5 -> "Very Unhealthy"
                        6 -> "Hazardous"
                        else -> {"undefined"}
                    }
                }
            } catch (e: IOException) {
                println("Internet error: ${e.message}")
            } catch (e: HttpException) {
                println("Unexpected response: ${e.message}")
            }
        }

        return binding.root
    }

}

