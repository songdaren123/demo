package com.it.roomdemo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher")
data class Teacher(@PrimaryKey var id: Long, var name: String) {
}