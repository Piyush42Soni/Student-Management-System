package com.example.aboutme.Main_Activities

import androidx.lifecycle.ViewModel
import com.example.aboutme.data.Person_Details
import com.example.aboutme.data.repositories.Person_Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel(private val repository:Person_Repo):ViewModel(){
    fun upsert(item:Person_Details ) =
    GlobalScope.launch(Dispatchers.IO) {
        repository.upsert(item)
    }

    fun delete(item: Person_Details) = GlobalScope.launch(Dispatchers.IO) {
        repository.delete(item)
    }

    fun getAllPersonsInfo() = repository.getAllPersonsInfo()

}
