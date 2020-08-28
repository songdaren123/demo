package com.it.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class, Teacher::class], version = 1)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    //数据库初始化时创建
    companion object {
        @Volatile
        private var instance: SchoolDatabase? = null;
        fun getInstance(context: Context): SchoolDatabase {
            return instance ?: buildDataBase(context).also { instance = it }
        }

        private fun buildDataBase(context: Context): SchoolDatabase {
            return Room.databaseBuilder(context, SchoolDatabase::class.java, "school_db")
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }).build()
        }
    }


}