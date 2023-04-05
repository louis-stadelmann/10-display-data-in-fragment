package com.example.fragmentviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentviewmodel.databinding.ActivityMainBinding
import com.example.fragmentviewmodel.viewModels.MainActivityViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentviewmodel.factory.MainActivityViewModelFactory

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

        viewModel.counterScore.observe(
            this
        ) {
            binding.counter.text = it.toString()
        }

        binding.btnAdd.setOnClickListener {
            viewModel.incrementCounterScore()
        }
    }
}