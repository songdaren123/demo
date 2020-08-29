package com.it.roomdemo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
    @PrimaryKey(autoGenerate = true) var id: Long,
    @ColumnInfo(name = "std_name") var name: String,
    @ColumnInfo(name = "std_class") var cls: String
)
