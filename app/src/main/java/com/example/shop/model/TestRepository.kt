package com.example.shop.model

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.shop.dao.TestDao
import com.example.shop.db.TestDatabase

class TestRepository(application: Application) {
    private val testDatabase: TestDatabase = TestDatabase.getInstance(application)!!
    private val testDao: TestDao = testDatabase.testDao()
    private val tests: LiveData<List<Test>> = testDao.getAll()

    fun getAll(): LiveData<List<Test>> {
        return tests
    }
    fun insert(todo: Test){
        testDao.insert(todo)
    }
    fun delete(todo: Test){
        testDao.delete(todo)
    }

    fun update(todo: Test){
        testDao.update(todo)
    }
}