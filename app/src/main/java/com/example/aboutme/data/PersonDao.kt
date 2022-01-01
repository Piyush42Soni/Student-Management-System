package com.example.aboutme.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: Person_Details)

    @Delete
    suspend fun delete(item: Person_Details)

    @Query("SELECT * FROM persons_table")
    fun getAllPersonsInfo(): LiveData<List<Person_Details>>
}