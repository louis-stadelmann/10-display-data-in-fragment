package com.example.fragmentviewmodel.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startNumber: Int) : ViewModel() {
    var counterScore = MutableLiveData(startNumber)

    fun incrementCounterScore() {
        counterScore.value = counterScore.value?.plus(1)
    }
}