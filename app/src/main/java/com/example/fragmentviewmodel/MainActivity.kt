package com.example.fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentviewmodel.databinding.ActivityMainBinding
import com.example.fragmentviewmodel.viewModels.MainActivityViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentviewmodel.factory.MainActivityViewModelFactory
import com.example.fragmentviewmodel.fragments.Fragment1

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    lateinit var viewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModelFactory = MainActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            viewModel.incrementCounterScore()
            val fragment1 = supportFragmentManager.findFragmentByTag("fragment1")

            if (fragment1 == null) {
                val fragTransaction = supportFragmentManager.beginTransaction()
                fragTransaction.replace(R.id.flMain, Fragment1(), "fragment1").commit()
            }
        /*else {
                val fragTransaction = supportFragmentManager.beginTransaction()
                fragTransaction.remove(fragment1).commit()
            }*/
        }
    }
}