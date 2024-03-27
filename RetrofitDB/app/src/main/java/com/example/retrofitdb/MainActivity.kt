package com.example.retrofitdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.retrofitdb.API.Posts
import com.example.retrofitdb.API.RetrofitInstance
import com.example.retrofitdb.Database.PostDatabase
import com.example.retrofitdb.Database.PostDatabaseDAO
import com.example.retrofitdb.Database.ViewModels.PostViewModel
import com.example.retrofitdb.Database.ViewModels.PostViewModelFactory
import com.example.retrofitdb.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostViewModel
    private lateinit var dataSource: PostDatabaseDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dataSource = PostDatabase.getInstance(application).postDatabaseDAO
        val viewModelFactory = PostViewModelFactory(dataSource,this.application)
        viewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]


        lifecycleScope.launch {
            val response = try {
                RetrofitInstance.api.getPost()
            } catch (e: IOException) {
                println("Internet error")
                setOff()
                return@launch
            } catch (e: HttpException) {
                println("Unexpected response")
                setOff()
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                convert(response)

            } else {
                println("Response not successful")
            }
        }
    }

    private suspend fun convert(response: Response<List<Posts>>){
        val comments = response.body()!!
        viewModel.clearData()

        for (comment in comments){
            insertEnt(title = comment.title, body = comment.body)
        }
        setOff()
    }

    private suspend fun insertEnt(title:String,body:String){
        viewModel.insertData(title,body)
    }

    private fun setOff(){
        viewModel.getDetails()
        var a = ""

        viewModel.title.forEach {
            a+=it
        }
        binding.tv.text = a
    }
}