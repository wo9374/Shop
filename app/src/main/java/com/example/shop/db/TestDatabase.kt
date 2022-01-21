package com.example.shop.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shop.model.Test
import com.example.shop.dao.TestDao

@Database(entities = [Test::class], version = 1)
abstract class TestDatabase : RoomDatabase() {
    abstract fun testDao() : TestDao

    //싱글톤 패턴
    companion object{
        private var Instance : TestDatabase? = null

        fun getInstance(context:Context): TestDatabase? {
            if (Instance == null) {
                synchronized(TestDatabase::class) { //synchronized: 여러 스레드가 동시에 접근 불가. 동기적으로 접근
                    Instance = Room.databaseBuilder(context.applicationContext,
                        TestDatabase::class.java, "test")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return Instance
        }
    }
}