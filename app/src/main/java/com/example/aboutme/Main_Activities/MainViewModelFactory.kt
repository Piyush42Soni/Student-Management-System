package com.example.aboutme.Main_Activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aboutme.data.repositories.Person_Repo

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: Person_Repo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}