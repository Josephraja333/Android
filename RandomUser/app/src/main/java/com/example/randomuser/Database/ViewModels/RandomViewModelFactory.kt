package com.example.randomuser.Database.ViewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomuser.Database.RandomDAO
import java.lang.IllegalArgumentException

class RandomViewModelFactory(private val dataSource: RandomDAO, private val application: Application): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RandomDataViewModel::class.java)){
            return RandomDataViewModel(dataSource, application) as T
        }

        throw IllegalArgumentException("Unknown viewmodel")
    }
}