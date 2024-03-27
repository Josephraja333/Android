package com.example.retrofitdb.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.retrofitdb.Database.Post
import com.example.retrofitdb.Database.PostDatabaseDAO

class PostViewModel(val database: PostDatabaseDAO, application: Application): AndroidViewModel(application) {
    var title : List<String> = listOf()

    fun clearData(){
        database.clear()
    }

    fun getDetails(){
        title = database.getTitle()
    }

    suspend fun insertData(title:String, body:String){
        database.insert(Post(title = title, body = body))
    }
}