package com.it.roomdemo

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Student::class], version = 2)
abstract class SchoolDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    //数据库初始化时创建
    companion object {
        @Volatile
        private var instance: SchoolDatabase? = null
//        private val MIGRATION_1_2 = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL("ALTER TABLE student ADD COLUMN std_address TEXT NOT NULL DEFAULT ''")
//            }
//        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE student ADD COLUMN age Integer NOT NULL DEFAULT 0")
            }
        }

        fun getInstance(context: Context): SchoolDatabase {
            return instance ?: buildDataBase(context).also { instance = it }
        }

        private fun buildDataBase(context: Context): SchoolDatabase {
            return databaseBuilder(context, SchoolDatabase::class.java, "school_db")
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                }).addMigrations(MIGRATION_1_2).build()
        }
    }


}