package com.it.roomdemo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Observable

@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student: Student): Long

    @Update
    fun updateStudent(student: Student): Long

    @Query("SELECT * FROM STUDENT")
    fun getAllStudentObservable(): Observable<Student>

    @Query("SELECT * FROM STUDENT")
    fun getAllStudentLiveData(): LiveData<Student>

    @Query("SELECT * FROM STUDENT")
    fun getAllStudentList(): List<Student>

    @Query("SELECT * FROM Student")
    suspend fun getAllStudentSuspend(): Array<Student>
}