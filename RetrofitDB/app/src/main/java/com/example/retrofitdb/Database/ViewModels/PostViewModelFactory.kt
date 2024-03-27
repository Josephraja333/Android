package com.example.retrofitdb.Database.ViewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitdb.Database.PostDatabaseDAO
import java.lang.IllegalArgumentException

class PostViewModelFactory (
    private val dataSource: PostDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(dataSource, application) as T
        }

        throw IllegalArgumentException("Unknown viewmodel")
    }
}