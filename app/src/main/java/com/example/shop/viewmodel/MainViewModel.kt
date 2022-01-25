package com.example.shop.viewmodel

import android.app.Application
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.*
import com.example.shop.R
import com.example.shop.model.Test
import com.example.shop.model.TestRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application){

    private val repository = TestRepository(application)
    private val test = repository.getAll()

    fun getAll() : LiveData<List<Test>> { return this.test }

    fun insert(test: Test){
        viewModelScope.launch(Dispatchers.IO){
            repository.insert(test)
        }
    }

    fun delete(test: Test){ repository.delete(test) }

    fun update(test: Test){ repository.update(test) }


    /*var openFlag: MutableLiveData<Boolean> = MutableLiveData(false)

    fun floatingOnClick(){
        openFlag.value = openFlag.value?.not()
    }*/
}