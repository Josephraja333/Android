package com.example.randomuser.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.randomuser.Database.RandomDAO
import com.example.randomuser.Database.RandomEntity

class RandomDataViewModel(val database: RandomDAO, application: Application): AndroidViewModel(application){

    fun clearData(){
        database.clear()
    }

    fun insertData(result: String){
        database.insert(RandomEntity(data = result))
    }
}