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
    @Query("SELECT * FROM STUDENT WhERE age>:age")
    fun getStudents(age: Int): Observable<List<Student>>

    //livedata
    @Query("SELECT * FROM STUDENT")
    fun getAllStudentLiveData(): LiveData<List<Student>>

    //协程
    @Query("SELECT * FROM STUDENT")
    fun getAllStudentList(): List<Student>

    @Query("SELECT * FROM Student")
    suspend fun getAllStudentSuspend(): List<Student>
}