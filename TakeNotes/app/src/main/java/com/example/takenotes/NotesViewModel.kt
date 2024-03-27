package com.example.takenotes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.ArrayList

class NotesViewModel : ViewModel(){
    var arraylist = MutableLiveData<ArrayList<String?>>()
}