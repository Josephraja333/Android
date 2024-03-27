package com.example.roomdata.Database.ViewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdata.Database.FormDatabaseDAO
import java.lang.IllegalArgumentException

class FormViewModelFactory(
    private val dataSource: FormDatabaseDAO,
    private val application: Application) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(FormViewModel::class.java)){
            return FormViewModel(dataSource, application) as T
        }

        throw IllegalArgumentException("Unknown viewmodel")
    }
}
