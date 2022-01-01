package com.example.aboutme.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
entities = [Person_Details::class],
version = 1
)
abstract class Person_Database: RoomDatabase() {

    abstract fun getPersonDao(): PersonDao

    companion object {
        @Volatile
        private var instance: Person_Database? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance
            ?: synchronized(LOCK) {
                instance
                    ?: createDatabase(
                        context
                    ).also { instance = it }
            }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                Person_Database::class.java, "PersonDB.db").build()
    }
}