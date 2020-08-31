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
    fun insertStudent(vararg student: Student)

    @Update
    fun updateStudent(vararg student: Student): Int

    //rxjava
    @Query("SELECT * FROM STUDENT")
    fun getAllStudentObservable(): Observable<List<Student>>

    //rxjava
    @Query("SELECT * FROM STUDENT WhERE std_name=:name")
    fun getStudents(name: String): Observable<List<Student>>

    //livedata
    @Query("SELECT * FROM STUDENT")
    fun getAllStudentLiveData(): LiveData<List<Student>>

    //协程
    @Query("SELECT * FROM STUDENT")
    suspend fun getAllStudentList(): List<Student>

    @Query("SELECT * FROM Student")
    fun getAllStudentSuspend(): List<Student>
}