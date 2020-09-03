package com.it.roomdemo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.it.roomdemo.data.LoginInfo

class LoginViewModel : ViewModel() {
    private var TAG = LoginViewModel::class.java.simpleName
    fun login(user: LoginInfo) {
        Log.d(TAG, "login: " + user.toString())
    }
}