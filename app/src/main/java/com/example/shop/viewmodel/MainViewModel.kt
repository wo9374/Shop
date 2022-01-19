package com.example.shop.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var count = MutableLiveData<Int>()

    init {
        count.value = 0
    }

    fun plus(){
        count.value = count.value?.plus(1)
    }

    fun minus(){
        count.value = count.value?.minus(1)
    }
}