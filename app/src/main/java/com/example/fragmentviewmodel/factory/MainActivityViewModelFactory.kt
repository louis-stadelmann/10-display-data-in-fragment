package com.example.fragmentviewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentviewmodel.viewModels.MainActivityViewModel

class MainActivityViewModelFactory(private val startingNumber : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(startingNumber) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}