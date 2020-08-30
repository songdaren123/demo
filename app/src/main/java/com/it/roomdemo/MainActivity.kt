package com.it.roomdemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val TAG: String = MainActivity::class.java.simpleName
    private lateinit var btInsert: Button
    private lateinit var btUpdate: Button
    private lateinit var btDelete: Button
    private lateinit var btSelect: Button
//    private val liubei = Student(id = 12, name = "刘备", cls = "三年二班")
//    private val caocao = Student(id = 13, name = "曹操", cls = "五年一班")
//    private val sunquan = Student(id = 14, name = "孙权", cls = "幼儿园小班")

    private val liubei =
        Student(id = 12, name = "刘备", cls = "三年二班", address = "巴蜀", age = 23)
    private val caocao =
        Student(id = 13, name = "曹操", cls = "五年一班", address = "许都", age = 28)
    private val sunquan =
        Student(id = 14, name = "孙权", cls = "幼儿园小班", address = "吴郡", age = 18)

    private lateinit var dao: StudentDao
    private val disposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btInsert = findViewById(R.id.bt_insert)
        btUpdate = findViewById(R.id.bt_update)
        btDelete = findViewById(R.id.bt_delete)
        btSelect = findViewById(R.id.bt_select)
        dao = SchoolDatabase.getInstance(applicationContext).studentDao()
        btInsert.setOnClickListener { insertByLiveDate() }
        btSelect.setOnClickListener { fromRxJava() }
        btUpdate.setOnClickListener { updata() }

    }

    private fun updata() {
        Thread(Runnable {
            dao.updateStudent(liubei, caocao, sunquan)
        }).start()
    }

    private fun insertByLiveDate() {
        Thread(Runnable {
            dao.insertStudent(liubei, caocao, sunquan)
        }).start()
    }

    //livedata
    private fun fromLiveData() {
        val fromLiveData = dao.getAllStudentLiveData()
        fromLiveData.observe(this, Observer { t ->
            printlnList(t)
        })
    }

    //rxjava
    private fun fromRxJava() {
        disposable.add(
            dao.getAllStudentObservable().subscribeOn(IoScheduler())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(Consumer { t -> printlnList(t) })
        )

    }

    //协程
    private fun fromCoroutines() {
        Log.d(TAG, "fromCoroutines 线程${Thread.currentThread().id}")
        GlobalScope.launch {
            Log.d(TAG, "协程线程${Thread.currentThread().id}")
            val students = dao.getAllStudentSuspend()
            printlnList(students)
        }

    }


    private fun printlnList(students: List<Student>) {
        for (student in students) {
            Log.d(TAG, "学生信息${student.toString()}")
        }
        Log.d(TAG, "线程${Thread.currentThread().id}")

    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }
}


