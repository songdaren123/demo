package com.it.roomdemo

class StudentRepository private constructor(private val studentDao: StudentDao) {
    fun getStudent() = studentDao.getAllStudentLiveData();

    companion object {
        @Volatile
        private var instance: StudentRepository? = null;
        fun getInstance(studentDao: StudentDao) = instance ?: synchronized(this) {
            instance ?: StudentRepository(studentDao).also { instance = it }
        }
    }
}