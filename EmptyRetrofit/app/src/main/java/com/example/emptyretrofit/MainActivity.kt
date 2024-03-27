package com.example.emptyretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.emptyretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import okio.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {

            val response = try{
                RetrofitInstance.api.getPhotos()
            }
            catch (e:IOException){
                println("Internet error")
                return@launchWhenCreated
            }
            catch (e: HttpException){
                println("Unexpected response")
                return@launchWhenCreated
            }
            var a = ""
            if(response.isSuccessful && response.body()!=null){

                response.body()!!.forEach { println(it.title)
                    a += it.title
                }
            }

            else{
                println("Response not successful")
            }
            withContext(Dispatchers.Main){
                binding.tv.text = a
            }
        }
    }
}