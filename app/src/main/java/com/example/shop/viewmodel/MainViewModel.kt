package com.example.shop.viewmodel

import android.app.Application
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop.R
import com.example.shop.model.Test
import com.example.shop.model.TestRepository

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository = TestRepository(application)
    private val test = repository.getAll()

    fun getAll() : LiveData<List<Test>> { return this.test }

    fun insert(test: Test){ repository.insert(test) }

    fun delete(test: Test){ repository.delete(test) }

    fun update(test: Test){ repository.update(test) }


    /*var openFlag: MutableLiveData<Boolean> = MutableLiveData(false)

    fun floatingOnClick(){
        openFlag.value = openFlag.value?.not()
    }*/
}