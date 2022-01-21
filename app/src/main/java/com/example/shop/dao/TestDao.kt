package com.example.shop.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shop.model.Test

@Dao
interface TestDao {
    @Query("SELECT * FROM Test")
    fun getAll(): LiveData<List<Test>>

    @Insert(onConflict = OnConflictStrategy.REPLACE) // 중복 ID일 경우 교체
    fun insert(todo: Test)

    @Update
    fun update(todo: Test)

    @Delete
    fun delete(todo: Test)
}