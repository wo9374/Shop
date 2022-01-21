package com.example.shop.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shop.R
import com.example.shop.adapter.TestAdapter
import com.example.shop.databinding.ActivityMainBinding
import com.example.shop.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()
    //by viewModels() 사용 안할때
    //val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setNavigationInit()
    }



    private fun setNavigationInit(){
        val navHostFragment = supportFragmentManager.findFragmentById(binding.mainNavHost.id) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupWithNavController(
            binding.bottomNavigationView, navController
        )
    }
}