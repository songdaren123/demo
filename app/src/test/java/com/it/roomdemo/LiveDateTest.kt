package com.it.roomdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 *
 * @ClassName:      LiveDateTest
 * @Description:    java类作用描述
 * @Author:         songdaren
 * @CreateDate:     2020/8/29 1:21 PM
 */
class LiveDateTest : LifecycleOwner {
    private lateinit var studentDao: StudentDao
    private val TAG = LiveDateTest::class.java.simpleName
    private val liubei = Student(101, "刘备", "三年二班")
    private val caocao = Student(102, "曹操", "五年一班")
    private val sunquan = Student(103, "孙权", "幼儿园小班")

//    @Rule
//    @JvmField
//    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun createData() {
//        val  context = ApplicationProvider.getApplicationContext()
//        studentDao = SchoolDatabase.getInstance(context).studentDao()
//        studentDao.insertStudent(liubei, caocao, sunquan)


    }

    @Test
    fun insertStudent() {
        Log.d(TAG, "insertStudent: ")
//        studentDao.getAllStudentLiveData()
//            .observe(this, Observer { t -> Log.d(TAG, "长度${t.size}") })
    }

    @After
    fun closeData() {

    }

    override fun getLifecycle(): Lifecycle {
        TODO("Not yet implemented")
    }
}