package com.it.roomdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel(repository: StudentRepository) : ViewModel() {
    val students: LiveData<Student> = repository.getStudent();

}