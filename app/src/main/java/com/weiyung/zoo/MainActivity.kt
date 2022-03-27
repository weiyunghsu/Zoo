package com.weiyung.zoo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.weiyung.zoo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.currentFragmentType.observe(
            this,
            Observer {
                Log.i("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
                Log.i("[${viewModel.currentFragmentType.value}]")
                Log.i("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
            }
        )
    }
}