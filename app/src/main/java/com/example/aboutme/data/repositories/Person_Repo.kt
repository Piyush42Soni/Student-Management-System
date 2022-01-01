package com.example.aboutme.data.repositories

import androidx.lifecycle.ViewModel
import com.example.aboutme.data.Person_Database
import com.example.aboutme.data.Person_Details
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Person_Repo(
    private val db: Person_Database
) {
    suspend fun upsert(item: Person_Details) = db.getPersonDao().upsert(item)

    suspend fun delete(item: Person_Details) = db.getPersonDao().delete(item)

    fun getAllPersonsInfo() = db.getPersonDao().getAllPersonsInfo()
}