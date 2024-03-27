package com.example.randomuser.Models

import androidx.lifecycle.ViewModel
import com.example.randomuser.DataBaseList
import com.example.randomuser.Database.ViewModels.RandomDataViewModel
import com.example.randomuser.RandomAPI.Result
import com.example.randomuser.RandomAPI.RetrofitRandomInstance
import com.google.gson.Gson
import java.io.IOException

class RandomViewModel(): ViewModel(){
     var displayUser : ArrayList<Result> = ArrayList()

    suspend fun addToList(dViewModel: RandomDataViewModel) {
        val response = try {
            RetrofitRandomInstance.api.getRandom()
        } catch (e: IOException) {
            val allDatas = dViewModel.database.getData()
            val st = Gson().fromJson(allDatas, DataBaseList::class.java)!!
            for (i in st.data){
                displayUser.add(i)
            }
            print(st::class.java)
            println("display user list $displayUser")
            return
        }

        if (response.isSuccessful&&response.body() != null) {
            response.body()?.results?.forEach {
                displayUser.add(it)
            }
            dViewModel.clearData()
            dViewModel.insertData(Gson().toJson(DataBaseList(displayUser)))
        } else {
            println("Unsuccessful response. Code: ${response.code()}, Message: ${response.message()}")
        }
    }

    fun filterList(query : String?): ArrayList<Result> {
        val filteredList = ArrayList<Result>()
        print(displayUser)
        if(query!=null){
            for(i in displayUser){
                if ((i.name.first+i.name.last).contains(query,ignoreCase = true)) {
                    if (!filteredList.contains(i)){
                        filteredList.add(i)
                    }
                }
            }
        }
        if(query == "") return displayUser
        return filteredList
    }
}