package com.example.roomdata.Database.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roomdata.Database.Form
import com.example.roomdata.Database.FormDatabaseDAO



class FormViewModel (val database: FormDatabaseDAO,application: Application ) : AndroidViewModel(application)
{
    val _email = MutableLiveData<String>()
    val _gender = MutableLiveData<String>()
    val _age = MutableLiveData<String>()
    val _name = MutableLiveData<String>()
    var _finalOut = MutableLiveData<String>()
    var finalOut : LiveData<String> = _finalOut

    fun clearData(){
        database.clear()
    }

    fun getDetails(){
        _name.value = database.getName()
        _gender.value = database.getGender()
        _email.value = database.getEmail()
        _age.value = database.getAge().toString()

        _finalOut.value = "Name is: ${_name.value}\nEmail is:${_email.value}\nGender: ${_gender.value}\nAge: ${_age.value} "
    }

    fun insertData(name:String, email:String, gender:String, age:String){
        database.insert(Form(name = name, email = email, gender = gender,age = age.toInt()))
    }

}