package com.example.aboutme.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons_table")
data class Person_Details(
    @ColumnInfo(name = "person_name")
    var name: String,
    @ColumnInfo(name = "person_age")
    var age: Int,
    @ColumnInfo
    var cgpa:Int,
    @ColumnInfo(name="person_address")
    var address:String,
    @ColumnInfo(name="person_number")
    var ph_number:String,
    @ColumnInfo(name="person_Education")
    var education:String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}