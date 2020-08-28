package com.it.roomdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Long,
    var name: String,
    var cls: String
)
