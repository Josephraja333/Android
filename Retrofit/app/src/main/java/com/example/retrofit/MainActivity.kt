package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        lifecycleScope.launch {
            binding.pb.isVisible = true

            val response = try {
                RetrofitInstance.api.getTodos()
            } catch (e: IOException) {
                println("Internet error")
                binding.pb.isVisible = false
                return@launch
            } catch (e: HttpException) {
                println("Unexpected response")
                binding.pb.isVisible = false
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                todoAdapter.submitList(response.body())
            } else {
                println("Response not successful")
            }
            binding.pb.isVisible = false
        }
    }

    private fun setupRecyclerView() = binding.rv.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this.context)
    }
}